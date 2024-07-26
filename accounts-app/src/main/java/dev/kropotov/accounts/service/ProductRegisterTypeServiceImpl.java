package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.mapper.ProductRegisterTypeMapper;
import dev.kropotov.accounts.repository.ProductRegisterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductRegisterTypeServiceImpl implements ProductRegisterTypeService {
    private final ProductRegisterTypeRepository productRegisterTypeRepository;
    private final ProductRegisterTypeMapper productRegisterTypeMapper;

    @Override
    public ProductRegisterTypeDto readByValue(String value) {
        return productRegisterTypeMapper.toDto(productRegisterTypeRepository.findByValue(value));
    }

    @Override
    public List<ProductRegisterTypeDto> readByProductClassValue(String value) {
        return productRegisterTypeRepository.findByProductClassValue(value).stream()
                .map(productRegisterTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}
