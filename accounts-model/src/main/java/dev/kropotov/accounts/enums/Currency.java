package dev.kropotov.accounts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Currency {
    CURRENCY500("500"),
    CURRENCY800("800");

    private final String code;
}
