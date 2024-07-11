package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.*;
import dev.kropotov.accounts.dto.request.CorporateSettlementAccountRequestDto;
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

        AccountDto accountDto = accountPoolDto.getAccounts().getFirst();
        ProductRegisterDto registerDto = new ProductRegisterDto()
                .setType(registerTypeDto)
                .setAccount(accountDto)
                .setCurrency(currency)
                .setState(State.OPEN);

        registerDto = productService.createProductRegister(productDto, registerDto);

        return new CorporateSettlementAccountResponseDto(registerDto.getId().toString());
    }
}
