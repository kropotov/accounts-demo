package dev.kropotov.accounts.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Ответ REST сервиса.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(description = "Ответ REST сервиса")
public class ResponsePayload<T> {
    /**
     * Бизнес-данные.
     */
    @Schema(description = "Бизнес-данные")
    private T data;

}
