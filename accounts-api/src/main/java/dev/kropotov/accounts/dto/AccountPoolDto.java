package dev.kropotov.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPoolDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Код филиала")
    @NotNull
    private Branch branch;

    @Schema(description = "Код валюты")
    @NotNull
    private Currency currency;

    @Schema(description = "Id клиента")
    private String mdmCode;

    @Schema(description = "Код срочности")
    private String priorityCode;

    @Schema(description = "Тип регистра")
    @Valid
    private ProductRegisterTypeDto registryType;

    @JsonIgnore
    private final List<AccountDto> accounts = new ArrayList<>();
}
