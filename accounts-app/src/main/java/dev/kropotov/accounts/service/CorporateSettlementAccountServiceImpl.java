package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.*;
import dev.kropotov.accounts.dto.request.CorporateSettlementAccountRequestDto;
import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementAccountResponseDto;

import dev.kropotov.accounts.enums.Branch;
import dev.kropotov.accounts.enums.Currency;
import dev.kropotov.accounts.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CorporateSettlementAccountServiceImpl implements CorporateSettlementAccountService {

    private final AccountPoolService accountPoolService;
    private final ProductService productService;
    private final ProductRegisterTypeService productRegisterTypeService;

    @Override
    public CorporateSettlementAccountResponseDto create(CorporateSettlementAccountRequestDto request) {
        ProductDto productDto = productService.readById(request.getInstanceId());
        ProductRegisterTypeDto registerTypeDto = productRegisterTypeService.readByValue(request.getRegistryTypeCode());
        Currency currency = Currency.findByCode(request.getCurrencyCode());
        Branch branch = Branch.findByCode(request.getBranchCode());

        AccountPoolDto accountPoolDto = accountPoolService.getAccountPool(
                branch,
                currency,
                request.getMdmCode(),
                request.getPriorityCode(),
                registerTypeDto
        );

        if (accountPoolDto == null) {
            throw new IllegalArgumentException("Не найден пул счетов с заданными параметрами"); //TODO: сдедать хендлер
        }

        AccountDto accountDto = accountPoolDto.getAccounts().getFirst();
        ProductRegisterDto registerDto = new ProductRegisterDto()
                .setType(registerTypeDto)
                .setAccount(accountDto)
                .setCurrency(currency)
                .setState(State.OPEN)
                .setAccountNumber(accountDto.getAccountNumber());

        registerDto = productService.createProductRegister(productDto, registerDto);

        return new CorporateSettlementAccountResponseDto(registerDto.getId().toString());
    }

    @Override
    public String create(CorporateSettlementInstanceRequestDto request) {
        CorporateSettlementAccountRequestDto accountRequest = new CorporateSettlementAccountRequestDto()
                .setInstanceId(request.getInstanceId())
                .setRegistryTypeCode(request.getRegisterType())
                .setAccountType("Клиентский")
                .setCurrencyCode(request.getIsoCurrencyCode())
                .setBranchCode(request.getBranchCode())
                .setPriorityCode("00")
                .setMdmCode(request.getMdmCode());
        return create(accountRequest).getAccountId();
    }
}
