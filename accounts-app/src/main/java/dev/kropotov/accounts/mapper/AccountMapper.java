package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountDto;
import dev.kropotov.accounts.entity.Account;
import dev.kropotov.accounts.repository.AccountPoolRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    @Autowired
    protected AccountPoolRepository accountPoolRepository;

    @Mapping(source = "accountPool.branch.code", target = "branchCode")
    @Mapping(source = "accountPool.currency.code", target = "currencyCode")
    @Mapping(source = "accountPool.mdmCode", target = "mdmCode")
    @Mapping(source = "accountPool.priorityCode", target = "priorityCode")
    @Mapping(source = "accountPool.registryTypeCode", target = "registryTypeCode")
    public abstract AccountDto toDto(Account account);

    @Mapping(target = "accountPool", expression = "java(accountPoolRepository.findAccountPoolByMdmCode(accountDto.getMdmCode()))")
    public abstract Account toEntity(AccountDto accountDto);
}
