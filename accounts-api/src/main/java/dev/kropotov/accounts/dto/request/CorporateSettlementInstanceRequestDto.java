package dev.kropotov.accounts.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateSettlementInstanceRequestDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    //TODO: добавить остальные поля

}
