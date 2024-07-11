package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.dto.ProductRegisterDto;

public interface ProductService extends BaseCrudService<ProductDto> {
    ProductRegisterDto createProductRegister(ProductDto productDto, ProductRegisterDto newProductRegisterDto);
}
