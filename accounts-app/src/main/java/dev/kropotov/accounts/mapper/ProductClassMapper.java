package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductClassDto;
import dev.kropotov.accounts.entity.ProductClass;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductClassMapper {
    ProductClassDto toDto(ProductClass productClass);

    ProductClass toEntity(ProductClassDto productClassDto);
}
