package dev.kropotov.accounts.controller.api;

import dev.kropotov.accounts.dto.common.ResponsePayload;
import dev.kropotov.accounts.dto.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.CorporateSettlementAccountResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Контроллер ПРОДУКТОВЫЙ РЕГИСТР (ПР)", description = "Предназначен для создания нового объекта ПРОДУКТОВЫЙ РЕГИСТР (ПР)")
@RequestMapping("/corporate-settlement-account")
public interface CorporateSettlementAccountApi {
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Создание новой записи",
            description = "Позволяет зарегистрировать новую запись в таблице"
    )
    ResponseEntity<ResponsePayload<CorporateSettlementAccountResponseDto>> create(
            @Valid @RequestBody CorporateSettlementAccountRequestDto dto);
}
