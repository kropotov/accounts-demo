package dev.kropotov.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSettlementAccountRequestDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
/*
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
    private State state;*/

    //TODO: добавить остальные поля

}
