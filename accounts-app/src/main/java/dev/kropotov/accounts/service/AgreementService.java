package dev.kropotov.accounts.service;


import dev.kropotov.accounts.dto.AgreementDto;

public interface AgreementService {
    AgreementDto create(AgreementDto newAgreementDto);
}
