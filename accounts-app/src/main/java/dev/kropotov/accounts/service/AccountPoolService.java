package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;

public interface AccountPoolService {
    AccountPoolDto getAccountPool(
            Branch branch, Currency currency, String mdmCode, String priorityCode, ProductRegisterTypeDto registryType);
}
