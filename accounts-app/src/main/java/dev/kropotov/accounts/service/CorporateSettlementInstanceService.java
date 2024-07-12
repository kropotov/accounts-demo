package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementInstanceResponseDto;


public interface CorporateSettlementInstanceService {
    CorporateSettlementInstanceResponseDto create(CorporateSettlementInstanceRequestDto request);
}
