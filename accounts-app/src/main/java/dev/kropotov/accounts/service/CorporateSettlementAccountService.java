package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.request.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementAccountResponseDto;


public interface CorporateSettlementAccountService {
    CorporateSettlementAccountResponseDto create(CorporateSettlementAccountRequestDto request);
    String create(CorporateSettlementInstanceRequestDto request);
}
