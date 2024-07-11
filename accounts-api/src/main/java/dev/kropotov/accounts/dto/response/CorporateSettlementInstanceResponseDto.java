package dev.kropotov.accounts.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSettlementInstanceResponseDto {

    @Schema(description = "Идентификатор продукта")
    @NotBlank
    private String instanceId;

    @Schema(description = "Идентификатор продуктового регистра, массив")
    private List<String> registerId;

    @Schema(description = "ID доп.соглашения, массив")
    private List<String> supplementaryAgreementId;

}
