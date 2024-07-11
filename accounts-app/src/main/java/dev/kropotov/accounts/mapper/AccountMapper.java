package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account account);

    @Mapping(target = "accountPool", ignore = true)
    Account toEntity(AccountDto accountDto);
}
