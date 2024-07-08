package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AccountPoolMapper.class)
public interface AccountMapper {
    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);
}
