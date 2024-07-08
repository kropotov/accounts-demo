package dev.kropotov.accounts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductServiceImplTest extends BaseTest {
    @Autowired
    private ProductService productService;

    private static final String PATH_PRODUCT = "/data/product.json";
    private static final String PATH_PRODUCTS = "/data/products-response-all.json";

    private ProductDto productDto;

    @Test
    @SneakyThrows
    void readAll() {
        List<ProductDto> response = productService.readAll();
        String jsonCurrent = objectMapper.writeValueAsString(response);
        String jsonEtalon = readResourceToString(PATH_PRODUCTS);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
    }

    @Test
    @BeforeEach
    @SneakyThrows
    void create() {
        productDto = objectMapper.readValue(readResourceToString(PATH_PRODUCT),
                new TypeReference<ProductDto>() {
                });
        ProductDto newProductDto = productService.create(productDto);
        productDto.setId(newProductDto.getId());
        assertEquals(productDto, newProductDto);
    }

    @Test
    void readById() {
        //TODO: all tests
        ProductDto newProductDto = productService.readById(productDto.getId());
        assertEquals(productDto.getId(), newProductDto.getId());
    }

    @Test
    void update() {
//        String oldProductNumber = "475335516415314841861";
//        String newProductNumber = "1";
//
//        ProductDto productDto = productService.readByProductNumber(oldProductNumber).getFirst();
//        productDto.setProductNumber(newProductNumber);
//        ProductDto newProductDto = productService.update(productDto.getId(), productDto);
//        assertEquals(newProductNumber, newProductDto.getProductNumber());
//        productDto.setProductNumber(oldProductNumber);
//        newProductDto = productService.update(productDto.getId(), productDto);
//        assertEquals(oldProductNumber, newProductDto.getProductNumber());
    }

    @Test
    @SneakyThrows
    void delete() {
        ProductDto productDto = objectMapper.readValue(readResourceToString(PATH_PRODUCT),
                new TypeReference<ProductDto>() {
                });
        ProductDto newProductDto = productService.create(productDto);
        productDto.setId(newProductDto.getId());
        assertEquals(productDto, newProductDto);
        productService.delete(newProductDto.getId());
        assertThrows(ResourceNotFoundException.class, () -> productService.readById(newProductDto.getId()));
    }
}
