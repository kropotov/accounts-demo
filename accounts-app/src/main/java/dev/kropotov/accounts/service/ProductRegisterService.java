package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductRegisterDto;

public interface ProductRegisterService {
    ProductRegisterDto create(ProductRegisterDto newProductRegisterDto);
}
