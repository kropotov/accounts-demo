package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.mapper.AccountPoolMapper;
import dev.kropotov.accounts.mapper.ProductRegisterTypeMapper;
import dev.kropotov.accounts.repository.AccountPoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountPoolServiceImpl implements AccountPoolService {
    private final AccountPoolRepository accountPoolRepository;
    private final AccountPoolMapper accountPoolMapper;
    private final ProductRegisterTypeMapper productRegisterTypeMapper;


    @Override
    public AccountPoolDto getAccountPool(
            Branch branch, Currency currency, String mdmCode, String priorityCode, ProductRegisterTypeDto registryType) {
        return accountPoolMapper.toDto(
                accountPoolRepository.findAccountPool(
                        branch, currency, mdmCode, priorityCode, productRegisterTypeMapper.toEntity(registryType) ));
    }
}
