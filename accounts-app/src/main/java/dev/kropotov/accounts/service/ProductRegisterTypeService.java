package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductRegisterTypeDto;

public interface ProductRegisterTypeService {
    ProductRegisterTypeDto readByValue(String value);
}
