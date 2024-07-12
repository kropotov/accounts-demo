package dev.kropotov.accounts.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface BaseCrudApi<T> {
    @PostMapping(value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Создание новой записи",
            description = "Позволяет зарегистрировать новую запись в таблице"
    )
    ResponseEntity<T> create(@Valid @RequestBody T dto);

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Получение записи по идентификатору",
            description = "Позволяет получить запись из таблицы по идентификатору"
    )
    ResponseEntity<T> readById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Изменение записи",
            description = "Позволяет изменить значения записи в таблицы по идентификатору"
    )
    ResponseEntity<T> update(@PathVariable("id") Long id, @Valid @RequestBody T updatedDto);

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Удаление записи",
            description = "Позволяет удалить запись из таблицы по идентификатору"
    )
    ResponseEntity<String> delete(@PathVariable("id") Long id);
}
