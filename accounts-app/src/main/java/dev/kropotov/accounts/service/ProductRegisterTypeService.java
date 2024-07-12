package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductRegisterTypeDto;

import java.util.List;

public interface ProductRegisterTypeService {
    ProductRegisterTypeDto readByValue(String value);

    List<ProductRegisterTypeDto> readByProductClassValue(String value);
}
