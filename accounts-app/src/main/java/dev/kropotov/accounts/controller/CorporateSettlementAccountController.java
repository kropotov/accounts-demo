package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.CorporateSettlementAccountApi;
import dev.kropotov.accounts.dto.common.ResponsePayload;
import dev.kropotov.accounts.dto.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.CorporateSettlementAccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CorporateSettlementAccountController implements CorporateSettlementAccountApi {
    @Override
    public ResponseEntity<ResponsePayload<CorporateSettlementAccountResponseDto>> create(
            CorporateSettlementAccountRequestDto dto) {
        //TODO: реализация контроллера
        return null;
    }
}
