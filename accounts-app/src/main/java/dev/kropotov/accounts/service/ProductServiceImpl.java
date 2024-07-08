package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.entity.Product;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import dev.kropotov.accounts.mapper.ProductMapper;
import dev.kropotov.accounts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto create(ProductDto dto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    @Override
    public List<ProductDto> readAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDto readById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
    }

    @Override
    public ProductDto update(Long id, ProductDto updatedDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        //TODO:all setters
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
