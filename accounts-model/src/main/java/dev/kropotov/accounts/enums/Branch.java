package dev.kropotov.accounts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Branch {
    HEAD("001"),
    EKB("002"),
    SIB("055"),
    BRANCH21("0021"),
    BRANCH22("0022");

    private final String code;
}
