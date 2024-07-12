package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.BaseTest;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.enums.State;
import dev.kropotov.accounts.service.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest extends BaseTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    ProductService productService;
    @MockBean
    AccountService accountService;
    @MockBean
    AccountPoolService accountPoolService;
    @MockBean
    ProductRegisterTypeService productRegisterTypeService;
    @MockBean
    ProductRegisterService productRegisterService;

    @Test
    @SneakyThrows
    void readById() {
        Mockito.when(this.productService.readById(1L)).thenReturn(getProducts().getFirst());

        mvc.perform(get("/api/products/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$.number").value("111"))
                .andExpect(jsonPath("$.type").value("договор"))
                .andExpect(jsonPath("$.priority").value(0L))
                .andExpect(jsonPath("$.productCode").value(1L));
    }

    @Test
    @SneakyThrows
    void readByAccountNumber() {
        Mockito.when(this.productService.readByProductNumber("111")).thenReturn(List.of(getProducts().getFirst()));

        mvc.perform(get("/api/products?number={number}", "111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$[0].number").value("111"))
                .andExpect(jsonPath("$[0].type").value("договор"))
                .andExpect(jsonPath("$[0].priority").value(0L))
                .andExpect(jsonPath("$[0].productCode").value(1L));
    }

    @Test
    @SneakyThrows
    void readAll() {
        Mockito.when(this.productService.readAll()).thenReturn(getProducts());

        mvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$[0].number").value("111"))
                .andExpect(jsonPath("$[0].type").value("договор"))
                .andExpect(jsonPath("$[0].priority").value(0L))
                .andExpect(jsonPath("$[0].productCode").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$[1].number").value("222"))
                .andExpect(jsonPath("$[1].type").value("договор"))
                .andExpect(jsonPath("$.[1].priority").value(0L))
                .andExpect(jsonPath("$[1].productCode").value(2L));
    }

    @Test
    @SneakyThrows
    void create() {
        ProductDto accountDto = getProducts().getFirst();
        Mockito.when(this.productService.create(accountDto)).thenReturn(accountDto);

        mvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(accountDto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$.number").value("111"))
                .andExpect(jsonPath("$.type").value("договор"))
                .andExpect(jsonPath("$.priority").value(0L))
                .andExpect(jsonPath("$.productCode").value(1L));
    }

    @Test
    @SneakyThrows
    void update() {
        ProductDto accountDto = getProducts().getFirst();
        accountDto.setNumber("112");
        Mockito.when(this.productService.update(1L, accountDto)).thenReturn(accountDto);

        mvc.perform(put("/api/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(accountDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.state").value(State.OPEN.toString()))
                .andExpect(jsonPath("$.number").value("112"))
                .andExpect(jsonPath("$.type").value("договор"))
                .andExpect(jsonPath("$.priority").value(0L))
                .andExpect(jsonPath("$.productCode").value(1L));

        accountDto.setNumber("111");
    }

    @Test
    @SneakyThrows
    void deleteTest() {
        mvc.perform(delete("/api/products/{id}", 1L))
                .andExpect(status().isOk());
    }

    private List<ProductDto> getProducts() {
        ProductDto one = new ProductDto(1L,
                State.OPEN,
                "111",
                new ArrayList<>(),
                new ArrayList<>(),
                "договор",
                1L,
                0L,
                LocalDate.now());

        ProductDto two = new ProductDto(2L,
                State.OPEN,
                "222",
                new ArrayList<>(),
                new ArrayList<>(),
                "договор",
                2L,
                0L,
                LocalDate.now());
        return List.of(one, two);
    }
}
