package dev.kropotov.accounts.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Branch {
    BRANCH0021("0021"),
    BRANCH0022("0022");

    @JsonValue
    private final String code;
}
