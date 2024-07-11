package dev.kropotov.accounts.dto;

import dev.kropotov.accounts.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    //TODO: все поля



}
