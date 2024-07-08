package dev.kropotov.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Номер счета")
    @NotBlank
    @Size(min = 1, max = 25)
    private String accountNumber;

    @Schema(description = "Пул счетов")
    @Valid
    private AccountPoolDto accountPool;

}
