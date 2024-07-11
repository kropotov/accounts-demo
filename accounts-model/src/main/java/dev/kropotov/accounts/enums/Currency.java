package dev.kropotov.accounts.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Currency {
    CURRENCY500("500"),
    CURRENCY800("800");

    @JsonValue
    private final String code;
}
