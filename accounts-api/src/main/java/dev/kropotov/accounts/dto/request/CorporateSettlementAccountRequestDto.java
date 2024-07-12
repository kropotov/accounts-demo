package dev.kropotov.accounts.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CorporateSettlementAccountRequestDto {
    @Schema(description = "Идентификатор экземпляра продукта")
    @NotNull
    private Long instanceId;

    @Schema(description = "Тип регистра")
    @NotBlank
    private String registryTypeCode;

    @Schema(description = "Тип счета")
    private String accountType;

    @Schema(description = "Код валюты")
    @Size(min = 1, max = 3)
    private String currencyCode;

    @Schema(description = "Код филиала")
    @Size(min = 1, max = 4)
    private String branchCode;

    @Schema(description = "Код срочности")
    private String priorityCode;

    @Schema(description = "Id клиента")
    @NotBlank
    private String mdmCode;

    @Schema(description = "Код клиента")
    private String clientCode;

    @Schema(description = "Регион принадлежности железной дороги")
    private String trainRegion;

    @Schema(description = "Счетчик")
    private String counter;

    @Schema(description = "Код точки продаж")
    private String salesCode;

}
