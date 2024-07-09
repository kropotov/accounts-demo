package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.entity.ProductRegister;
import dev.kropotov.accounts.enums.Currency;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface ProductRegisterMapper {
    @Mapping(source = "productRegister.currency.code", target = "currencyCode")
    ProductRegisterDto toDto(ProductRegister productRegister);

    @EnumMapping(nameTransformationStrategy = MappingConstants.STRIP_PREFIX_TRANSFORMATION, configuration = "CURRENCY")
    Currency toCurrency(String code);

    @Mapping(target = "currency", expression = "java(toCurrency(productRegisterDto.getCurrencyCode()))")
     ProductRegister toEntity(ProductRegisterDto productRegisterDto);
}
