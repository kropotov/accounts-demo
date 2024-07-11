package dev.kropotov.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgreementDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Номер ДС")
    @NotBlank
    private String number;

    @Schema(description = "Дата начала сделки")
    @NotNull
    private LocalDate openingDate;
}
