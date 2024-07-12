package dev.kropotov.accounts.service;

import dev.kropotov.accounts.dto.AgreementDto;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.dto.ProductRegisterTypeDto;
import dev.kropotov.accounts.dto.request.CorporateSettlementInstanceRequestDto;
import dev.kropotov.accounts.dto.response.CorporateSettlementInstanceResponseDto;
import dev.kropotov.accounts.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateSettlementInstanceServiceImpl implements CorporateSettlementInstanceService {
    private final ProductService productService;
    private final ProductRegisterTypeService productRegisterTypeService;
    private final CorporateSettlementAccountService corporateSettlementAccountService;

    @Override
    public CorporateSettlementInstanceResponseDto create(CorporateSettlementInstanceRequestDto request) {
        ProductDto productDto;
        List<String> productRegisterIdList= new ArrayList<>();
        if (request.getInstanceId() == null) {
            List<ProductDto> productDtoList = productService.readByProductNumber(request.getContractNumber());
            if (!productDtoList.isEmpty()) {
                throw new IllegalArgumentException("Параметр ContractNumber № договора " +
                        request.getContractNumber() +
                        " уже существует для ЭП с ИД " + productDtoList.getFirst().getId()); //TODO: нужен хэндлер
            }
            productDto = new ProductDto()
                    .setState(State.OPEN)
                    .setNumber(request.getContractNumber())
                    .setType(request.getProductType())
                    .setPriority(request.getPriority())
                    .setDateOfConclusion(request.getContractDate());

            productDto = productService.create(productDto);
            productService.setProductClass(productDto, request.getProductCode());

            List<ProductRegisterTypeDto> registerTypeDtoList = productRegisterTypeService.readByProductClassValue(
                    productDto.getProductClass().getValue());

            request.setInstanceId(productDto.getId());

            registerTypeDtoList.stream()
                    .filter(registerTypeDto -> registerTypeDto.getValue().equals(request.getRegisterType()))
                    .forEach(registerTypeDto -> productRegisterIdList.add(corporateSettlementAccountService.create(request)));
        } else {
            productDto = productService.readById(request.getInstanceId());
            if (productDto == null) {
                throw new IllegalArgumentException("Экземпляр продукта с параметром instanceId " +
                        request.getInstanceId() +" не найден.");
            }
            for (AgreementDto arrangement : request.getInstanceArrangement()) {
                productService.createAgreement(productDto, arrangement);
            }
        }
        return new CorporateSettlementInstanceResponseDto(productDto.getId().toString(),
                productRegisterIdList,
                productDto.getAgreements().stream().map(agreementDto -> agreementDto.getId().toString()).toList()
        );
    }
}