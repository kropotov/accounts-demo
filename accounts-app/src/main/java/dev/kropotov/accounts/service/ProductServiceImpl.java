package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.entity.Product;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import dev.kropotov.accounts.mapper.AgreementMapper;
import dev.kropotov.accounts.mapper.ProductClassMapper;
import dev.kropotov.accounts.mapper.ProductMapper;
import dev.kropotov.accounts.mapper.ProductRegisterMapper;
import dev.kropotov.accounts.repository.ProductClassRepository;
import dev.kropotov.accounts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductClassRepository productClassRepository;
    private final ProductMapper productMapper;
    private final ProductRegisterMapper productRegisterMapper;
    private final ProductClassMapper productClassMapper;
    private final ProductRegisterService productRegisterService;
    private final ProductRegisterTypeService productRegisterTypeService;
    private final AgreementMapper agreementMapper;

    @Override
    public ProductDto create(ProductDto dto) {
        if (dto.getRegisters() != null) {
            dto.getRegisters().forEach(productRegisterDto -> productRegisterDto.setType(
                    productRegisterTypeService.readByValue(productRegisterDto.getType().getValue())));
        }
        if (dto.getProductClass() != null) {
            dto.setProductClass(productClassMapper.toDto(
                    productClassRepository.findProductClassByValue(dto.getProductClass().getValue())));
        }
        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = true) //TODO: убрать
    public List<ProductDto> readAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true) //TODO: убрать
    public ProductDto readById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    @Transactional(readOnly = true) //TODO: убрать
    public List<ProductDto> readByProductNumber(String number) {
        return productRepository.findProductByNumber(number).stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto update(Long id, ProductDto updatedDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setNumber(updatedDto.getNumber());
        product.setState(updatedDto.getState());
        updatedDto.getRegisters().forEach(registerDto -> registerDto.setType(
                        productRegisterTypeService.readByValue(registerDto.getType().getValue())));

        product.setRegisters(updatedDto.getRegisters().stream()
                .map(productRegisterMapper::toEntity)
                .collect(Collectors.toList())); //нельзя сразу toList(), т.к. будет UnsupportedOperationException
        //т.к. создается immutable - лист, а нужен мутабельный

        if (updatedDto.getProductClass() != null) {
            product.setProductClass(productClassRepository.findProductClassByValue(updatedDto.getProductClass().getValue()));
        }
        product.setType(updatedDto.getType());
        product.setDateOfConclusion(updatedDto.getDateOfConclusion());

        product.setAgreements(updatedDto.getAgreements().stream()
                .map(agreementMapper::toEntity)
                .collect(Collectors.toList()));

        //TODO: все сеттеры после добавления полей
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductRegisterDto createProductRegister(ProductDto productDto, ProductRegisterDto newProductRegisterDto) {
        ProductRegisterDto finalNewProductRegisterDto = newProductRegisterDto;
        if (productDto.getRegisters().stream()
                .anyMatch(productRegisterDto ->
                        productRegisterDto.getType().getValue().equals(finalNewProductRegisterDto.getType().getValue())
                )) {
            throw new IllegalArgumentException("Параметр registryTypeCode тип регистра " +
                    newProductRegisterDto.getType().getValue() +
                    " уже существует для ЭП с ИД " + productDto.getId()); //TODO: нужен хэндлер
        }

        newProductRegisterDto = productRegisterService.create(newProductRegisterDto);
        productDto.getRegisters().add(newProductRegisterDto);

        update(productDto.getId(), productDto);
        return newProductRegisterDto;
    }
}
