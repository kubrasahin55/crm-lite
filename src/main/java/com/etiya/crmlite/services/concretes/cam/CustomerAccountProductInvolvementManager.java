package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.ServiceShortCodes;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import com.etiya.crmlite.repositories.cam.ICustomerAccountProductInvolvementRepository;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.abstracts.cam.ICustomerAccountProductInvolvementService;
import com.etiya.crmlite.services.abstracts.prod.ICampaignService;
import com.etiya.crmlite.services.constants.Messages;
import com.etiya.crmlite.services.responses.cam.addr.GetAddressResponse;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetAllCustomerAccountProductInvolvementResponse;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetCustomerAccountProductInvolvementResponse;
import com.etiya.crmlite.services.responses.prod.prodCharVal.GetAllProductCharacteristicValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerAccountProductInvolvementManager implements ICustomerAccountProductInvolvementService {
    private ICustomerAccountProductInvolvementRepository customerAccountProductInvolvementRepository;
    private ICampaignService campaignService;
    private IAddressService addressService;
    private IMessageSourceService messageSource;

    @Autowired
    public CustomerAccountProductInvolvementManager(ICustomerAccountProductInvolvementRepository customerAccountProductInvolvementRepository,
                                                    ICampaignService campaignService,@Lazy IAddressService addressService,
                                                    IMessageSourceService messageSource) {
        this.customerAccountProductInvolvementRepository = customerAccountProductInvolvementRepository;
        this.campaignService = campaignService;
        this.addressService = addressService;
        this.messageSource = messageSource;
    }

    @Override
    public DataResult<List<GetAllCustomerAccountProductInvolvementResponse>> getAll(Long custAcctId) {
        List<CustAcctProdInvl> custAcctProdInvls = this.customerAccountProductInvolvementRepository.findAllByCustAcctCustAcctId(custAcctId);
        List<GetAllCustomerAccountProductInvolvementResponse> response = new ArrayList<>();
        for (CustAcctProdInvl custAcctProdInvl : custAcctProdInvls) {
            GetAllCustomerAccountProductInvolvementResponse responseItem = new GetAllCustomerAccountProductInvolvementResponse();
            responseItem.setCustAcctProdInvlId(custAcctProdInvl.getCustAcctProdInvlId());
            responseItem.setProductId(custAcctProdInvl.getProd().getProdId());
            responseItem.setProductName(custAcctProdInvl.getProd().getName());
            if (custAcctProdInvl.getProd().getCmpgId() != null) {
                responseItem.setCampaignId(custAcctProdInvl.getProd().getCmpgId());
                responseItem.setCampaignName(this.campaignService.getCmpgById(custAcctProdInvl.getProd().getCmpgId()).getName());
            }
            response.add(responseItem);
        }
        return new SuccessDataResult<>(response, messageSource.getMessage(Messages.CustomerAccountProductInvolvement
                .SUCCESS_CUST_ACCT_PROD_INVL));
    }

    @Override
    public DataResult<GetCustomerAccountProductInvolvementResponse> getById(Long custAcctProdInvlId) {
        CustAcctProdInvl result = this.customerAccountProductInvolvementRepository.findById(custAcctProdInvlId).orElseThrow(() -> {
            throw new BusinessException(messageSource.getMessage
                    (Messages.CustomerAccountProductInvolvement.ERROR_CUST_ACCT_PROD_INVL));
        });
        GetCustomerAccountProductInvolvementResponse response = GetCustomerAccountProductInvolvementResponse.builder()
                .productOfferId(result.getProd().getProdOfr().getProdOfrId())
                .productOfferName(result.getProd().getProdOfr().getName())
                .productSpecificationId(result.getProd().getProdSpec().getProdSpecId())
                .productCharacteristics(result.getProd().getProdCharVals().stream().
                        map(charValue -> GetAllProductCharacteristicValueResponse.builder()
                                .generalCharacterName(charValue.getGnlChar().getName())
                                .value(charValue.getVal()).build()).collect(Collectors.toList())
                        )
                .build();

        if (result.getProd().getProdSpec().getProdSpecSrvcSpecs().stream()
                .anyMatch(prodSpecSrvcSpec -> prodSpecSrvcSpec.getSrvcSpec().getSrvcCode().equals(ServiceShortCodes.INTERNET_SERVICE))){
            Addr serviceAddress = this.addressService.getProductAddress(result.getProd().getProdId());
            response.setServiceAddress(GetAddressResponse.builder()
                            .addressId(serviceAddress.getAddrId())
                            .buildingId(serviceAddress.getBldgId())
                            .addressDescription(serviceAddress.getAddrDesc())
                            .cityName(serviceAddress.getCityName())
                            .streetName(serviceAddress.getStrtName())
                    .build());
        }
        return new SuccessDataResult<>(response, messageSource.getMessage(Messages.CustomerAccountProductInvolvement
                .SUCCESS_CUST_ACCT_PROD_INVL));
    }
}
