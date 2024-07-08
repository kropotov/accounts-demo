package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountDto;

import java.util.List;

public interface AccountService extends BaseCrudService<AccountDto> {
    List<AccountDto> readByAccountNumber(String accountNumber);
}
