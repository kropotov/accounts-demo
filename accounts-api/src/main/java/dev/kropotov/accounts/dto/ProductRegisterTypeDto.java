package dev.kropotov.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegisterTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "1")
    private Long id;

    @Schema(description = "Тип регистра", example = "03.012.002_47533_ComSoLd")
    @NotBlank
    private String value;

    @Schema(description = "Код продукта в каталоге продуктов", example = "{\"id\": 1, \"value\": \"03.012.002\"}")
    @Valid
    @JsonIgnore
    private ProductClassDto productClass;

}
