package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.entity.Account;
import dev.kropotov.accounts.exceptions.ResourceNotFoundException;
import dev.kropotov.accounts.mapper.AccountMapper;
import dev.kropotov.accounts.mapper.AccountPoolMapper;
import dev.kropotov.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountPoolMapper accountPoolMapper;
    private final AccountPoolService accountPoolService;

    @Override
    public List<AccountDto> readByAccountNumber(String accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber).stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Override
    public AccountDto create(AccountDto dto) {
        dto.setAccountPool(
                accountPoolService.getAccountPool(
                        dto.getAccountPool().getBranch(),
                        dto.getAccountPool().getCurrency(),
                        dto.getAccountPool().getMdmCode(),
                        dto.getAccountPool().getPriorityCode(),
                        dto.getAccountPool().getRegistryType()));
        return accountMapper.toDto(accountRepository.save(accountMapper.toEntity(dto)));
    }

    @Override
    public List<AccountDto> readAll() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).toList();
    }

    @Override
    public AccountDto readById(Long id) {
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found")));
    }

    @Override
    public AccountDto update(Long id, AccountDto updatedDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        account.setAccountNumber(updatedDto.getAccountNumber());
        account.setAccountPool(
                accountPoolMapper.toEntity(
                        accountPoolService.getAccountPool(
                                updatedDto.getAccountPool().getBranch(),
                                updatedDto.getAccountPool().getCurrency(),
                                updatedDto.getAccountPool().getMdmCode(),
                                updatedDto.getAccountPool().getPriorityCode(),
                                updatedDto.getAccountPool().getRegistryType())));
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
