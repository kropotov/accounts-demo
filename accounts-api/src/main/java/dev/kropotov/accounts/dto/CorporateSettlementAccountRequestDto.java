package dev.kropotov.accounts.dto;

import dev.kropotov.accounts.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSettlementAccountRequestDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Тип регистра")
    @NotBlank
    private ProductRegisterTypeDto type;

    @Schema(description = "Счет")
    @Valid
    private AccountDto account;

    @Schema(description = "Код валюты")
    @NotBlank
    @Size(min = 1, max = 3)
    private String currencyCode;

    @Schema(description = "Состояние")
    @Range(min = 1, max = 3)
    private State state;

    //TODO: добавить остальные поля

}
