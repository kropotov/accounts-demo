package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AccountPoolDto;

public interface AccountPoolService {
    AccountPoolDto readByMdmCode(String mdmCode);
}
