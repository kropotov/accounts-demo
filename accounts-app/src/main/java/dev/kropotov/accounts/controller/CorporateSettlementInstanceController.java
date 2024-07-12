package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.CorporateSettlementInstanceApi;
import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementInstanceResponseDto;
import dev.kropotov.accounts.dto.response.common.ResponsePayload;
import dev.kropotov.accounts.service.CorporateSettlementInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CorporateSettlementInstanceController implements CorporateSettlementInstanceApi {
    private final CorporateSettlementInstanceService corporateSettlementInstanceService;

    @Override
    public ResponseEntity<ResponsePayload<CorporateSettlementInstanceResponseDto>> create(CorporateSettlementInstanceRequestDto request) {
        CorporateSettlementInstanceResponseDto responseDto = corporateSettlementInstanceService.create(request);
        return ResponseEntity.ok(new ResponsePayload<>(responseDto));
    }
}
