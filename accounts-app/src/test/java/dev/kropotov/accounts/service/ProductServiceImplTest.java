package dev.kropotov.accounts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductServiceImplTest extends BaseServiceTest {
    @Autowired
    private ProductService productService;

    private static final String PATH_PRODUCT = "/data/product.json";
    private static final String PATH_PRODUCTS = "/data/products-response-all.json";

    private ProductDto productDto;

    @Test
    void readAll() {
        List<ProductDto> response = productService.readAll();
        String jsonCurrent = asJsonString(response);
        String jsonEtalon = readResourceToString(PATH_PRODUCTS);
        System.out.println("jsonCurrent: " + jsonCurrent);
        System.out.println("jsonEtalon: " + jsonEtalon);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
    }

    @Test
    @BeforeEach
    @SneakyThrows
    void create() {
        String jsonEtalon = readResourceToString(PATH_PRODUCT);
        productDto = objectMapper.readValue(jsonEtalon,
                new TypeReference<ProductDto>() {
                });
        ProductDto newProductDto = productService.create(productDto);
        String jsonCurrent = asJsonString(newProductDto);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
        productDto = newProductDto;
    }

    @Test
    void readById() {
        ProductDto newProductDto = productService.readById(productDto.getId());
        assertEquals(productDto, newProductDto);
    }

    @Test
    void update() {
        String oldNumber = productDto.getNumber();
        String newNumber = oldNumber + "1";
        productDto.setNumber(newNumber);
        ProductDto newProductDto = productService.update(productDto.getId(), productDto);
        assertEquals(productDto, newProductDto);
        productDto.setNumber(oldNumber);
        newProductDto = productService.update(productDto.getId(), productDto);
        assertEquals(productDto, newProductDto);
    }

    @Test
    @AfterEach
    @SneakyThrows
    void delete() {
        ProductDto newProductDto = productService.create(productDto);
        productDto.setId(newProductDto.getId());
        assertEquals(productDto, newProductDto);
        productService.delete(newProductDto.getId());
        assertThrows(ResourceNotFoundException.class, () -> productService.readById(newProductDto.getId()));
    }
}
