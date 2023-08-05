package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.CustomerTypes;
import com.etiya.crmlite.core.utilities.enums.GeneralTypes;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import com.etiya.crmlite.entities.concretes.common.GnlSt;
import com.etiya.crmlite.entities.concretes.common.GnlTp;
import com.etiya.crmlite.repositories.cam.ICustomerAccountRepository;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.abstracts.cam.ICustomerAccountService;
import com.etiya.crmlite.services.abstracts.cam.ICustomerService;
import com.etiya.crmlite.services.abstracts.common.IGeneralStatusService;
import com.etiya.crmlite.services.abstracts.common.IGeneralTypeService;
import com.etiya.crmlite.services.constants.Messages;
import com.etiya.crmlite.services.requests.cam.custAcct.CreateCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.DeleteCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.UpdateCustomerAccountRequest;
import com.etiya.crmlite.services.responses.cam.custAcct.CreateCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.GetCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.UpdateCustomerAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerAccountManager implements ICustomerAccountService {

    private ICustomerAccountRepository customerAccountRepository;
    private IGeneralStatusService generalStatusService;
    private IGeneralTypeService generalTypeService;
    private ICustomerService customerService;
    private IAddressService addressService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public CustomerAccountManager(ICustomerAccountRepository customerAccountRepository, IGeneralStatusService generalStatusService,
                                  IGeneralTypeService generalTypeService, @Lazy ICustomerService customerService,
                                  IAddressService addressService, IMessageSourceService messageSourceService) {
        this.customerAccountRepository = customerAccountRepository;
        this.generalStatusService = generalStatusService;
        this.generalTypeService = generalTypeService;
        this.customerService = customerService;
        this.addressService = addressService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<CreateCustomerAccountResponse> add(CreateCustomerAccountRequest createCustomerAccountRequest) {
        CustAcct custAcct = CustAcct.builder()
                .cust(customerService.getCustById(createCustomerAccountRequest.getCustomerId()))
                .acctName(createCustomerAccountRequest.getAccountName())
                .stId(StatusCode.CUST_ACCT_ACTV)
                .acctTpId(GeneralTypes.BILL_ACCT)
                .descr(createCustomerAccountRequest.getDescription())
                .build();
        custAcct = this.customerAccountRepository.save(custAcct);
        custAcct.setAcctNo(String.valueOf(custAcct.getCustAcctId()));
        custAcct = this.customerAccountRepository.save(custAcct);
        Addr addr=this.addressService.addAccountAddress(createCustomerAccountRequest.getAddressRequest(), custAcct.getCustAcctId());
        CreateCustomerAccountResponse response = CreateCustomerAccountResponseBuilder(createCustomerAccountRequest);
        return new SuccessDataResult(response, messageSourceService.getMessage(Messages.CustomerAccount.SUCCESS_CUST_ACCT_CREATE)) ;
    }

    @Override
    public void addCustomerAccountWhenCustomerCreation(Cust cust) {
        CustAcct custAcctWhenCreate = CustAcct.builder()
                .cust(cust)
                .acctTpId(GeneralTypes.CUST_ACCT)
                .acctName(CustomerTypes.CUST_ACCT)
                .stId(StatusCode.CUST_ACCT_ACTV)
                .descr(CustomerTypes.CUST_ACCT)
                .build();
        custAcctWhenCreate = this.customerAccountRepository.save(custAcctWhenCreate);
        custAcctWhenCreate.setAcctNo(String.valueOf(custAcctWhenCreate.getCustAcctId()));
        this.customerAccountRepository.save(custAcctWhenCreate);

    }

    @Override
    public DataResult<UpdateCustomerAccountResponse> update(UpdateCustomerAccountRequest updateCustomerAccountRequest) {
        CustAcct updateCustAcct = this.customerAccountRepository.findById(updateCustomerAccountRequest.getCustomerAccountId())
                .orElseThrow(() -> {
                    throw new BusinessException(messageSourceService.getMessage
                            (Messages.CustomerAccount.ERROR_CUST_ACCT_UPDATE));
                });
        updateCustAcct.setAcctName(updateCustomerAccountRequest.getAccountName());
        updateCustAcct.setDescr(updateCustomerAccountRequest.getDescription());
        customerAccountRepository.save(updateCustAcct);

        if(updateCustomerAccountRequest.getUpdateAddressRequest() != null) {
            this.addressService.updateAddress(updateCustomerAccountRequest.getUpdateAddressRequest());
        }
        UpdateCustomerAccountResponse response = UpdateCustomerAccountResponseBuilder(updateCustomerAccountRequest);
        return new SuccessDataResult(response, messageSourceService.getMessage(Messages.CustomerAccount.SUCCESS_CUST_ACCT_UPDATE));
    }

    @Override
    public Result delete(DeleteCustomerAccountRequest deleteCustomerAccountRequest) {
        CustAcct deleteCustAcct = this.customerAccountRepository.findById(deleteCustomerAccountRequest.getCustomerAccountId()).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.CustomerAccount.ERROR_CUST_ACCT_DELETE));
        });
        checkProdIsExist(deleteCustAcct);
        deleteCustAcct.setStId(StatusCode.CUST_ACCT_DEL);
        this.customerAccountRepository.save(deleteCustAcct);
        return new SuccessResult(messageSourceService.getMessage(Messages.CustomerAccount.SUCCESS_CUST_ACCT_DELETE));
    }

    @Override
    public DataResult<List<GetCustomerAccountResponse>> getAllByCustomerId(Long customerId) {
        List<CustAcct> result = this.customerAccountRepository.findAllByCustomerId(customerId);
        List<GetCustomerAccountResponse> response = result.stream()
                .filter(custAcct -> custAcct.getStId() == StatusCode.CUST_ACCT_ACTV)
                .map(custAcct -> GetCustomerAccountResponse.builder()
                        .customerAccountId(custAcct.getCustAcctId())
                        .accountNumber(custAcct.getAcctNo())
                        .accountName(custAcct.getAcctName())
                        .accountStatus(convertStatusIdToString(custAcct))
                        .accountType(convertAccountTypeIdToString(custAcct))
                        .build())
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.CustomerAccount.SUCCESS_CUST_ACCT_GET));
    }

    private void checkProdIsExist(CustAcct custAcct){
        if(custAcct.getCustAcctProdInvls().size()>0){
            throw new BusinessException(messageSourceService.getMessage(Messages.CustomerAccount.CHECK_PROD_IS_EXIST));
        }
    }

    private String convertStatusIdToString(CustAcct custAcct) {
        GnlSt gnlSt = this.generalStatusService.findById(custAcct.getStId());
        return gnlSt.getName();
    }

    private String convertAccountTypeIdToString(CustAcct custAcct) {
        GnlTp gnlTp = this.generalTypeService.findById(custAcct.getAcctTpId());
        return gnlTp.getName();
    }

    private CreateCustomerAccountResponse CreateCustomerAccountResponseBuilder(CreateCustomerAccountRequest createCustomerAccountRequest) {
        CreateCustomerAccountResponse response = CreateCustomerAccountResponse.builder()
                .customerId(createCustomerAccountRequest.getCustomerId())
                .description(createCustomerAccountRequest.getDescription())
                .accountName(createCustomerAccountRequest.getAccountName())
                .addressRequest(createCustomerAccountRequest.getAddressRequest())
                .build();
        return response;
    }

    private UpdateCustomerAccountResponse UpdateCustomerAccountResponseBuilder(UpdateCustomerAccountRequest updateCustomerAccountRequest) {
        UpdateCustomerAccountResponse response = UpdateCustomerAccountResponse.builder()
                .customerAccountId(updateCustomerAccountRequest.getCustomerAccountId())
                .description(updateCustomerAccountRequest.getDescription())
                .accountName(updateCustomerAccountRequest.getAccountName())
                .updateAddressRequest(updateCustomerAccountRequest.getUpdateAddressRequest())
                .build();
        return response;
    }
}
