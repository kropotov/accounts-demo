package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AgreementDto;
import dev.kropotov.accounts.mapper.AgreementMapper;
import dev.kropotov.accounts.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;

    @Override
    public AgreementDto create(AgreementDto newAgreementDto) {
        return agreementMapper.toDto(
                agreementRepository.save(
                        agreementMapper.toEntity(newAgreementDto)));
    }
}
