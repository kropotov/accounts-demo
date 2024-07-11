package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.CorporateSettlementAccountApi;
import dev.kropotov.accounts.dto.response.common.ResponsePayload;
import dev.kropotov.accounts.dto.request.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementAccountResponseDto;
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
        CorporateSettlementAccountResponseDto responseDto = new CorporateSettlementAccountResponseDto();
        responseDto.setAccountId("11111111111111111");
        return ResponseEntity.ok(new ResponsePayload<>(responseDto));
    }
}
