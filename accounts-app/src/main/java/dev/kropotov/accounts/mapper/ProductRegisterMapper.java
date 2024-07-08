package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.entity.ProductRegister;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRegisterMapper {
    ProductRegisterDto toDto(ProductRegister productRegister);

    ProductRegister toEntity(ProductRegisterDto productRegisterDto);
}
