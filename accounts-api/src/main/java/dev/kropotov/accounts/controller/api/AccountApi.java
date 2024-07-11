package dev.kropotov.accounts.controller.api;

import dev.kropotov.accounts.dto.AccountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Контроллер счетов (для прикола)", description = "Предоставляет REST-full API-интерфейс для работы со списокм счетов")
@RequestMapping("/api/accounts")
public interface AccountApi extends BaseCrudApi<AccountDto> {
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Получение записи по имени/всех записей, если не указан параметр accountNumber",
            description = "Позволяет получить список всех записей в таблице"
    )
    ResponseEntity<List<AccountDto>> readByAccountNumber(@RequestParam(required = false) String accountNumber);
}
