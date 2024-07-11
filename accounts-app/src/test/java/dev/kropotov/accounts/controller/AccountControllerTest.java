package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.BaseTest;
import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.service.AccountPoolService;
import dev.kropotov.accounts.service.AccountService;
import dev.kropotov.accounts.service.ProductRegisterTypeService;
import dev.kropotov.accounts.service.ProductService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest extends BaseTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    AccountService accountService;
    @MockBean
    AccountPoolService accountPoolService;
    @MockBean
    ProductService productService;
    @MockBean
    ProductRegisterTypeService productRegisterTypeService;

    @Test
    @SneakyThrows
    void readById() {
        Mockito.when(this.accountService.readById(1L)).thenReturn(getAccounts().getFirst());

        mvc.perform(get("/api/accounts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.accountNumber").value("111"));
    }

    @Test
    @SneakyThrows
    void readByAccountNumber() {
        Mockito.when(this.accountService.readByAccountNumber("111")).thenReturn(List.of(getAccounts().getFirst()));

        mvc.perform(get("/api/accounts?accountNumber={accountNumber}", "111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].accountNumber").value("111"));
    }

    @Test
    @SneakyThrows
    void readAll() {
        Mockito.when(this.accountService.readAll()).thenReturn(getAccounts());

        mvc.perform(get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].accountNumber").value("111"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].accountNumber").value("222"));
    }

    @Test
    @SneakyThrows
    void create() {
        AccountDto accountDto = getAccounts().getFirst();
        Mockito.when(this.accountService.create(accountDto)).thenReturn(accountDto);

        mvc.perform(post("/api/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(accountDto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.accountNumber").value("111"));
    }

    @Test
    @SneakyThrows
    void update() {
        AccountDto accountDto = getAccounts().getFirst();
        accountDto.setAccountNumber("112");
        Mockito.when(this.accountService.update(1L, accountDto)).thenReturn(accountDto);

        mvc.perform(put("/api/accounts/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(accountDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.accountNumber").value("112"));

        accountDto.setAccountNumber("111");
    }

    @Test
    @SneakyThrows
    void deleteTest() {
        mvc.perform(delete("/api/accounts/{id}", 1L))
                .andExpect(status().isOk());
    }

    private List<AccountDto> getAccounts() {
        AccountDto one = new AccountDto(1L,
                "111");
        AccountDto two = new AccountDto(2L,
                "222");
        return List.of(one, two);
    }
}
