package dev.kropotov.accounts.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CorporateSettlementAccountRequestDto {
    @Schema(description = "Идентификатор экземпляра продукта")
    @NotNull
    private Long instanceId;

    @Schema(description = "Тип регистра")
    private String registryTypeCode;

    @Schema(description = "Тип счета")
    private String accountType;

    @Schema(description = "Код валюты")
    @Size(min = 1, max = 3)
    private String currencyCode;

    @Schema(description = "Код филиала")
    @Size(min = 1, max = 4)
    private String branchCode;

    @Schema(description = "Код срочности")
    private String priorityCode;

    @Schema(description = "Id клиента")
    private String mdmCode;

    @Schema(description = "Код клиента")
    private String clientCode;

    @Schema(description = "Регион принадлежности железной дороги")
    private String trainRegion;

    @Schema(description = "Счетчик")
    private String counter;

    @Schema(description = "Код точки продаж")
    private String salesCode;
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
