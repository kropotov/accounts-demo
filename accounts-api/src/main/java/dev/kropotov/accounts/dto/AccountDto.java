package dev.kropotov.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Номер счета")
    @NotBlank
    @Size(min = 1, max = 25)
    private String accountNumber;

    @Schema(description = "Код филиала")
    @NotBlank
    @Size(min = 1, max = 4)
    private String branchCode;

    @Schema(description = "Код валюты")
    @NotBlank
    @Size(min = 1, max = 3)
    private String currencyCode;

    @Schema(description = "Id клиента")
    private String mdmCode;

    @Schema(description = "Код срочности")
    private String priorityCode;

    @Schema(description = "Тип регистра")
    private String registryTypeCode;

}
