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
import org.hibernate.validator.constraints.Range;

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

    @Schema(description = "Счет")
    @Valid
    private AccountDto account;

    @Schema(description = "Код валюты")
    @NotNull
    private Currency currency;

    @Schema(description = "Состояние")
    @Range(min = 1, max = 3)
    private State state;

    @Schema(description = "Номер счета")
    private String accountNumber;

}
