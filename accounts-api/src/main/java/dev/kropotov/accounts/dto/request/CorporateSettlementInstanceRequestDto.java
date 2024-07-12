package dev.kropotov.accounts.dto.request;

import dev.kropotov.accounts.dto.AgreementDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSettlementInstanceRequestDto {
    @Schema(description = "Идентификатор экземпляра продукта")
    private Long instanceId;

    @Schema(description = "массив Доп.Соглашений")
    @Valid
    List<AgreementDto> instanceArrangement = new ArrayList<>();

    @Schema(description = "Тип Экземпляра Продукта")
    @NotBlank
    private String productType; //TODO: enum

    @Schema(description = "Код продукта в каталоге продуктов")
    @NotBlank
    private String productCode;

    @Schema(description = "Тип регистра")
    @NotBlank
    private String registerType;

    @Schema(description = "Код Клиента (mdm)")
    @NotBlank
    private String mdmCode;

    @Schema(description = "Номер договора")
    @NotBlank
    private String contractNumber;

    @Schema(description = "Дата заключения договора обслуживания")
    @NotBlank
    private LocalDate contractDate;

    @Schema(description = "Приоритет")
    @NotNull
    private Long priority;

    @Schema(description = "ID Договора")
    @NotNull
    private Long contractId;

    @Schema(description = "Код филиала")
    @Size(min = 1, max = 4)
    private String branchCode;

    @Schema(description = "Код валюты")
    @Size(min = 1, max = 3)
    private String IsoCurrencyCode;

    @Schema(description = "Код срочности договора")
    @NotBlank
    String urgencyCode;

}
