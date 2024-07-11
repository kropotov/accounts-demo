package dev.kropotov.accounts.dto;

import dev.kropotov.accounts.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Состояние")
    @NotBlank
    private State state;

    @Schema(description = "Номер продукта")
    private String number;

    @Schema(description = "Регистры")
    private List<ProductRegisterDto> registers = new ArrayList<>();

    @Schema(description = "Доп. соглашения")
    private List<AgreementDto> agreements = new ArrayList<>();

    @Schema(description = "Тип Экземпляра Продукта")
    @NotBlank
    private String type; //TODO: enum

    @Schema(description = "Код продукта в каталоге продуктов")
    @NotNull
    private Long productCode;

    @Schema(description = "Дата заключения договора обслуживания")
    @NotNull
    private LocalDate dateOfConclusion;

    //TODO: все поля
}
