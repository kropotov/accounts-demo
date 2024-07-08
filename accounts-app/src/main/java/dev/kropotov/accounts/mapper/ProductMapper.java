package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductRegisterMapper.class)
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
