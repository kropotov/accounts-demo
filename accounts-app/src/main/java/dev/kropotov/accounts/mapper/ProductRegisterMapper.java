package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.entity.ProductRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountMapper.class, ProductRegisterTypeMapper.class})
public interface ProductRegisterMapper {
    ProductRegisterDto toDto(ProductRegister productRegister);

    @Mapping(target = "product", ignore = true)
    ProductRegister toEntity(ProductRegisterDto productRegisterDto);
}
