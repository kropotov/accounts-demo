package dev.kropotov.accounts.mapper;

import dev.kropotov.accounts.dto.AccountPoolDto;
import dev.kropotov.accounts.entity.AccountPool;
import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring", uses = ProductRegisterTypeMapper.class)
public interface AccountPoolMapper {
    @Mapping(source = "accountPool.branch.code", target = "branchCode")
    @Mapping(source = "accountPool.currency.code", target = "currencyCode")
    AccountPoolDto toDto(AccountPool accountPool);

    @EnumMapping(nameTransformationStrategy = MappingConstants.STRIP_PREFIX_TRANSFORMATION, configuration = "CURRENCY")
    Currency toCurrency(String code);

    @EnumMapping(nameTransformationStrategy = MappingConstants.STRIP_PREFIX_TRANSFORMATION, configuration = "BRANCH")
    Branch toBranch(String code);

    @Mapping(target = "branch", expression = "java(toBranch(accountPoolDto.getBranchCode()))")
    @Mapping(target = "currency", expression = "java(toCurrency(accountPoolDto.getCurrencyCode()))")
    @Mapping(target = "accounts", ignore = true)
    AccountPool toEntity(AccountPoolDto accountPoolDto);
}
