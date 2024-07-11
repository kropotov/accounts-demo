package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.CorporateSettlementInstanceApi;
import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementInstanceResponseDto;
import dev.kropotov.accounts.dto.response.common.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CorporateSettlementInstanceController implements CorporateSettlementInstanceApi {
    @Override
    public ResponseEntity<ResponsePayload<CorporateSettlementInstanceResponseDto>> create(CorporateSettlementInstanceRequestDto dto) {
        //TODO: реализация контроллера
        CorporateSettlementInstanceResponseDto responseDto = new CorporateSettlementInstanceResponseDto();
        responseDto.setInstanceId("111");
        return ResponseEntity.ok(new ResponsePayload<>(responseDto));
    }
}
