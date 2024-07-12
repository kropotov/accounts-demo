package dev.kropotov.accounts.dto;

import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductRegisterDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Тип регистра")
    @Valid
    private ProductRegisterTypeDto type;

    @Schema(description = "Счет", example = "{\"id\": 1, \"accountNumber\": \"475335516415314841861\"}")
    @Valid
    private AccountDto account;

    @Schema(description = "Код валюты", example = "800")
    @NotNull
    private Currency currency;

    @Schema(description = "Состояние", example = "OPEN")
    private State state;

    @Schema(description = "Номер счета", example = "475335516415314841861")
    private String accountNumber;

}
