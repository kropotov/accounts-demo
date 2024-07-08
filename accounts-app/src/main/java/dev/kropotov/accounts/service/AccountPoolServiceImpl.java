package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.mapper.AccountPoolMapper;
import dev.kropotov.accounts.repository.AccountPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountPoolServiceImpl implements AccountPoolService {
    private final AccountPoolRepository accountPoolRepository;
    private final AccountPoolMapper accountPoolMapper;

    @Override
    public AccountPoolDto readByMdmCode(String mdmCode) {
        return accountPoolMapper.toDto(accountPoolRepository.findAccountPoolByMdmCode(mdmCode));
    }
}
