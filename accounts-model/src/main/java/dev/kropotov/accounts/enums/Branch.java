package dev.kropotov.accounts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Branch {
    HEAD("001"),
    EKB("002"),
    SIB("055"),
    BRANCH0021("0021"),
    BRANCH0022("0022");

    private final String code;
}
