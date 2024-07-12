package dev.kropotov.accounts.controller.api;

import dev.kropotov.accounts.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Контроллер продуктов", description = "Предоставляет REST-full API-интерфейс для работы со списокм продуктов")
@RequestMapping("/api/products")
public interface ProductApi extends BaseCrudApi<ProductDto> {
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Получение записи по имени/всех записей, если не указан параметр number",
            description = "Позволяет получить список всех записей в таблице"
    )
    ResponseEntity<List<ProductDto>> readByProductNumber(@RequestParam(required = false) String number);
}
