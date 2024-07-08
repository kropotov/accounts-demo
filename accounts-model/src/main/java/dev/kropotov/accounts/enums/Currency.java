package dev.kropotov.accounts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Currency {
    RUB("810"),
    EUR("978"),
    USD("840"),
    CURRENCY500("500"),
    CURRENCY800("800");

    private final String code;
}
