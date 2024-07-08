package dev.kropotov.accounts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceImplTest extends BaseTest {
    @Autowired
    private AccountService accountService;

    private static final String PATH_ACCOUNT = "/data/account.json";
    private static final String PATH_ACCOUNTS = "/data/accounts-response-all.json";

    @Test
    void readByAccountNumber() {
        String accountNumber = "475335516415314841861";
        AccountDto accountDto = accountService.readByAccountNumber(accountNumber).getFirst();
        assertEquals(accountNumber, accountDto.getAccountNumber());
    }

    @Test
    @SneakyThrows
    void readAll() {
        List<AccountDto> response = accountService.readAll();
        String jsonCurrent = objectMapper.writeValueAsString(response);
        String jsonEtalon = readResourceToString(PATH_ACCOUNTS);
        assertJsonEqualWithoutId(jsonEtalon, jsonCurrent);
    }

    @Test
    @SneakyThrows
    void create() {
        AccountDto accountDto = objectMapper.readValue(readResourceToString(PATH_ACCOUNT),
                new TypeReference<AccountDto>() {
                });
        AccountDto newAccountDto = accountService.create(accountDto);
        accountDto.setId(newAccountDto.getId());
        assertEquals(accountDto, newAccountDto);
    }

    @Test
    void readById() {
        String accountNumber = "475335516415314841861";
        AccountDto accountDto = accountService.readByAccountNumber(accountNumber).getFirst();
        AccountDto newAccountDto = accountService.readById(accountDto.getId());
        assertEquals(accountDto.getId(), newAccountDto.getId());
    }

    @Test
    void update() {
        String oldAccountNumber = "475335516415314841861";
        String newAccountNumber = "1";

        AccountDto accountDto = accountService.readByAccountNumber(oldAccountNumber).getFirst();
        accountDto.setAccountNumber(newAccountNumber);
        AccountDto newAccountDto = accountService.update(accountDto.getId(), accountDto);
        assertEquals(newAccountNumber, newAccountDto.getAccountNumber());
        accountDto.setAccountNumber(oldAccountNumber);
        newAccountDto = accountService.update(accountDto.getId(), accountDto);
        assertEquals(oldAccountNumber, newAccountDto.getAccountNumber());
    }

    @Test
    @SneakyThrows
    void delete() {
        AccountDto accountDto = objectMapper.readValue(readResourceToString(PATH_ACCOUNT),
                new TypeReference<AccountDto>() {
                });
        AccountDto newAccountDto = accountService.create(accountDto);
        accountDto.setId(newAccountDto.getId());
        assertEquals(accountDto, newAccountDto);
        accountService.delete(newAccountDto.getId());
        assertThrows(ResourceNotFoundException.class, () -> accountService.readById(newAccountDto.getId()));
    }
}
