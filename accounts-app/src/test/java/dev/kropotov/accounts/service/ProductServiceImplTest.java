package dev.kropotov.accounts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.dto.ProductRegisterDto;
import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.State;
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

    @Autowired
    private ProductRegisterTypeService productRegisterTypeService;

    private static final String PATH_PRODUCT = "/data/product.json";
    private static final String PATH_PRODUCTS = "/data/products-response-all.json";

    private ProductDto productDto;

    @Test
    @BeforeEach
    @SneakyThrows
    void create() {
        String jsonEtalon = readResourceToString(PATH_PRODUCT);
        productDto = objectMapper.readValue(jsonEtalon,
                new TypeReference<>() {
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
    void readByNumber() {
        List<ProductDto> response = productService.readByProductNumber("111");
        String jsonCurrent = asJsonString(response);
        String jsonEtalon = readResourceToString(PATH_PRODUCTS);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
    }

    @Test
    void readAll() {
        List<ProductDto> response = productService.readAll();
        String jsonCurrent = asJsonString(response);
        String jsonEtalon = readResourceToString(PATH_PRODUCTS);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
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
    void createProductRegister() {
        ProductRegisterTypeDto registerTypeDto = productRegisterTypeService.readByValue("02.001.005_45343_CoDowFF");

        ProductRegisterDto registerDto = new ProductRegisterDto()
                .setType(registerTypeDto)
                .setCurrency(Currency.CURRENCY500)
                .setState(State.OPEN);

        registerDto = productService.createProductRegister(productDto, registerDto);

        assertEquals(registerDto, productDto.getRegisters().getLast());


        ProductRegisterDto secondRegisterDto = new ProductRegisterDto()
                .setType(registerTypeDto)
                .setCurrency(Currency.CURRENCY800)
                .setState(State.OPEN);
        assertThrows(IllegalArgumentException.class, () -> productService.createProductRegister(productDto, secondRegisterDto));
    }

    @Test
    @AfterEach
    void delete() {
        productService.delete(productDto.getId());
        assertThrows(ResourceNotFoundException.class, () -> productService.readById(productDto.getId()));
    }
}
