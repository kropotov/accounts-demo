package dev.kropotov.accounts.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Branch {
    BRANCH0021("0021"),
    BRANCH0022("0022");

    @JsonValue
    private final String code;

    public static Branch findByCode(String code) {
        return Arrays.stream(values()).filter(branch -> branch.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
