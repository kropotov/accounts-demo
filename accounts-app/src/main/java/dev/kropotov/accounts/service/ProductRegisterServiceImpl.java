package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.mapper.ProductRegisterMapper;
import dev.kropotov.accounts.repository.ProductRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductRegisterServiceImpl implements ProductRegisterService {

    private final ProductRegisterRepository productRegisterRepository;
    private final ProductRegisterMapper productRegisterMapper;

    @Override
    public ProductRegisterDto create(ProductRegisterDto newProductRegisterDto) {
        return productRegisterMapper.toDto(
                productRegisterRepository.save(
                        productRegisterMapper.toEntity(newProductRegisterDto)));
    }
}
