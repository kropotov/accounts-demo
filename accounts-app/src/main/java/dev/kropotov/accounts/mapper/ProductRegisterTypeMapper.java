package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.entity.ProductRegisterType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRegisterTypeMapper {
    ProductRegisterTypeDto toDto(ProductRegisterType productRegisterType);

    ProductRegisterType toEntity(ProductRegisterTypeDto productRegisterTypeDto);
}
