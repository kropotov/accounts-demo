package dev.kropotov.accounts.controller.api;

import dev.kropotov.accounts.dto.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.CorporateSettlementInstanceResponseDto;
import dev.kropotov.accounts.dto.common.ResponsePayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Контроллер ЭКЗЕМПЛЯР ПРОДУКТА (ЭП)", description = "Педназначен для создания нового объекта ЭКЗЕМПЛЯР ПРОДУКТА (ЭП)")
@RequestMapping("/corporate-settlement-instance")
public interface CorporateSettlementInstanceApi {
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Создание новой записи",
            description = "Позволяет зарегистрировать новую запись в таблице"
    )
    ResponseEntity<ResponsePayload<CorporateSettlementInstanceResponseDto>> create(
            @Valid @RequestBody CorporateSettlementInstanceRequestDto dto);
}
