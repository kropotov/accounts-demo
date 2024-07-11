package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AgreementDto;
import dev.kropotov.accounts.entity.Agreement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    AgreementDto toDto(Agreement agreement);

    @Mapping(target = "product", ignore = true)
    Agreement toEntity(AgreementDto agreementDto);
}
