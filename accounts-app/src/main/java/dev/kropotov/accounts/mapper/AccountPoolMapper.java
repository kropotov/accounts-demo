package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.entity.AccountPool;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductRegisterTypeMapper.class, AccountMapper.class})
public interface AccountPoolMapper {
    AccountPoolDto toDto(AccountPool accountPool);

    AccountPool toEntity(AccountPoolDto accountPoolDto);
}
