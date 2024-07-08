package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.AccountApi;
import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final AccountService accountService;

    @Override
    public ResponseEntity<AccountDto> create(AccountDto dto) {
        return ResponseEntity.ok(accountService.create(dto));
    }

    @Override
    public ResponseEntity<List<AccountDto>> readByAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return ResponseEntity.ok(accountService.readAll());
        }
        return ResponseEntity.ok(accountService.readByAccountNumber(accountNumber));
    }

    @Override
    public ResponseEntity<AccountDto> readById(Long id) {
        return ResponseEntity.ok(accountService.readById(id));
    }

    @Override
    public ResponseEntity<AccountDto> update(Long id, AccountDto updatedDto) {
        return ResponseEntity.ok(accountService.update(id, updatedDto));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        accountService.delete(id);
        return ResponseEntity.ok("Account deleted");
    }
}
