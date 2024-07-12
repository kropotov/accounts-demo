package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AgreementDto;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.dto.ProductRegisterDto;

import java.util.List;

public interface ProductService extends BaseCrudService<ProductDto> {
    List<ProductDto> readByProductNumber(String number);
    ProductRegisterDto createProductRegister(ProductDto productDto, ProductRegisterDto newProductRegisterDto);
    ProductDto setProductClass(ProductDto productDto, String value);
    AgreementDto createAgreement(ProductDto productDto, AgreementDto agreementDto);
}
