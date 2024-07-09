package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.entity.Product;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import dev.kropotov.accounts.mapper.ProductMapper;
import dev.kropotov.accounts.mapper.ProductRegisterMapper;
import dev.kropotov.accounts.mapper.ProductRegisterTypeMapper;
import dev.kropotov.accounts.repository.ProductRegisterTypeRepository;
import dev.kropotov.accounts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductRegisterMapper productRegisterMapper;
    private final ProductRegisterTypeMapper productRegisterTypeMapper;
    private final ProductRegisterTypeRepository productRegisterTypeRepository;

    @Override
    public ProductDto create(ProductDto dto) {
        dto.getRegisters().forEach(productRegisterDto -> productRegisterDto.setType(
                productRegisterTypeMapper.toDto(
                        productRegisterTypeRepository.findRegisterTypeByValue(productRegisterDto.getType().getValue()))));

        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> readAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto readById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    public ProductDto update(Long id, ProductDto updatedDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setNumber(updatedDto.getNumber());
        product.setState(updatedDto.getState());
        product.setRegisters(updatedDto.getRegisters().stream().map(productRegisterMapper::toEntity).toList());
        //TODO: все сеттеры после добавления полей
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
