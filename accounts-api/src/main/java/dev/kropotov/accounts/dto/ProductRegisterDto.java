package dev.kropotov.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegisterDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    //TODO: все поля

}
