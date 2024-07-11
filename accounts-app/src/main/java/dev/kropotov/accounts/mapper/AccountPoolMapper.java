package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.entity.AccountPool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductRegisterTypeMapper.class)
public interface AccountPoolMapper {
    AccountPoolDto toDto(AccountPool accountPool);

    @Mapping(target = "accounts", ignore = true)
    AccountPool toEntity(AccountPoolDto accountPoolDto);
}
