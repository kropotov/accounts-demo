package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.CorporateSettlementAccountApi;
import dev.kropotov.accounts.dto.response.common.ResponsePayload;
import dev.kropotov.accounts.dto.request.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementAccountResponseDto;
import dev.kropotov.accounts.service.CorporateSettlementAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CorporateSettlementAccountController implements CorporateSettlementAccountApi {
    private final CorporateSettlementAccountService corporateSettlementAccountService;

    @Override
    public ResponseEntity<ResponsePayload<CorporateSettlementAccountResponseDto>> create(
            CorporateSettlementAccountRequestDto request) {
        CorporateSettlementAccountResponseDto responseDto =
                corporateSettlementAccountService.create(request);
        return ResponseEntity.ok(new ResponsePayload<>(responseDto));
    }
}
