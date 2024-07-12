package dev.kropotov.accounts.dto;

import dev.kropotov.accounts.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Состояние", example = "OPEN")
    private State state;

    @Schema(description = "Номер продукта", example = "1")
    private String number;

    @Schema(description = "Регистры")
    @Valid
    private List<ProductRegisterDto> registers = new ArrayList<>();

    @Schema(description = "Доп. соглашения")
    @Valid
    private List<AgreementDto> agreements = new ArrayList<>();

    @Schema(description = "Тип Экземпляра Продукта", example = "договор")
    @NotBlank
    private String type; //TODO: enum

    @Schema(description = "Код продукта в каталоге продуктов", example = "12")
    @NotNull
    private Long productCode;

    @Schema(description = "Дата заключения договора обслуживания", example = "2024-07-03")
    @NotNull
    private LocalDate dateOfConclusion;

    //TODO: все поля
}
