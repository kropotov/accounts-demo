package dev.kropotov.accounts.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Currency {
    CURRENCY500("500"),
    CURRENCY800("800");

    @JsonValue
    private final String code;

    public static Currency findByCode(String code) {
        return Arrays.stream(values()).filter(currency -> currency.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
