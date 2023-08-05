package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.CustomerTypes;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.*;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repositories.cam.ICustomerRepository;
import com.etiya.crmlite.services.abstracts.cam.*;
import com.etiya.crmlite.services.constants.Messages;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.DeleteCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.FilterCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;
import com.etiya.crmlite.services.responses.cam.cust.CreateCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.DeleteCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.FilterCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.UpdateCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements ICustomerService {
    private ICustomerRepository customerRepository;
    private IIndividualService individualService;
    private ICustomerTypeService customerTypeService;
    private IPartyRoleService partyRoleService;
    private IPartyService partyService;
    private IAddressService addressService;
    private IContactMediumService contactMediumService;
    private ICustomerAccountService customerAccountService;
    private IMessageSourceService messageSourceService;


    @Autowired
    public CustomerManager(ICustomerRepository customerRepository, IIndividualService individualService,
                           ICustomerTypeService customerTypeService, IPartyRoleService partyRoleService,
                           IPartyService partyService, IAddressService addressService, IContactMediumService contactMediumService,
                           ICustomerAccountService customerAccountService, IMessageSourceService messageSourceService)
    {
        this.customerRepository = customerRepository;
        this.individualService = individualService;
        this.customerTypeService = customerTypeService;
        this.partyRoleService = partyRoleService;
        this.partyService = partyService;
        this.contactMediumService = contactMediumService;
        this.addressService = addressService;
        this.customerAccountService = customerAccountService;
        this.messageSourceService = messageSourceService;
    }

    //FR9-FR11
    @Transactional
    @Override
    public DataResult<CreateCustomerResponse> add(CreateCustomerRequest createCustomerRequest) {
        Ind createIndividual = individualService.createIndividual(createCustomerRequest);
        Cust createCust = createCust();
        PartyRole createdPartyRole = partyRoleService.createPartyRole(createCust);
        createCust.setPartyRole(createdPartyRole);
        Party createdParty = partyService.createParty(createIndividual, createdPartyRole);
        createIndividual.setParty(createdParty);
        createdPartyRole.setParty(createdParty);
        Party savedParty = this.partyService.save(createdParty);
        customerRepository.save(createCust);

        createCustomerRequest.getAddressWhenCreateCustomerRequests()
                .forEach(createAddressWhenCreateCustomerRequest ->
                        addressService.addAddress(createAddressWhenCreateCustomerRequest, savedParty));

        this.contactMediumService.createContactMediumWhenCustomerCreation(createCustomerRequest, savedParty.getPartyId());
        CreateCustomerResponse response = CreateCustomerResponseBuilder(createCustomerRequest,createCust);
        customerAccountService.addCustomerAccountWhenCustomerCreation(createCust);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Customer.SUCCESS_CUST_CREATE));
    }

    public DataResult<UpdateCustomerResponse> update(UpdateCustomerRequest updateCustomerRequest) {
        Cust cust = customerRepository.findById(updateCustomerRequest.getCustId()).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.Customer.ERROR_CUST_UPDATE));
        });

        Ind ind = cust.getPartyRole().getParty().getInd();
        this.individualService.updateIndividual(ind, updateCustomerRequest);
        UpdateCustomerResponse response = UpdateCustomerResponseBuilder(updateCustomerRequest,cust);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Customer.SUCCESS_CUST_UPDATE));
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        Cust deleteCustomer = this.customerRepository.findById(deleteCustomerRequest.getCustomerId()).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.Customer.ERROR_CUST_DELETE));
        });;
        checkProductIsExist(deleteCustomer);
        deleteCustomer.setStId(StatusCode.CUST_PASS);
        deleteCustomer.getPartyRole().getParty().setStId(StatusCode.PARTY_DEL);
        deleteCustomer.getPartyRole().setStId(StatusCode.PARTY_ROLE_DEL);
        deleteCustomer.getPartyRole().getParty().getInd().setStId(StatusCode.IND_DEL);
        this.customerRepository.save(deleteCustomer);
        return new SuccessResult(messageSourceService.getMessage(Messages.Customer.SUCCESS_CUST_DELETE));
    }

    //FR4
    @Override
    public DataResult<List<FilterCustomerResponse>> filter(FilterCustomerRequest filterCustomerRequest) {
        List<Cust> result = customerRepository.filterCustomers(filterCustomerRequest.getNationalityId(),
                filterCustomerRequest.getCustomerId(), filterCustomerRequest.getAccountNumber(), filterCustomerRequest.getGsmNumber(),
                filterCustomerRequest.getFirstName(), filterCustomerRequest.getLastName(), filterCustomerRequest.getOrderId());

        List<FilterCustomerResponse> responses = new ArrayList<>();

        for (Cust cust : result
        ) {
            FilterCustomerResponse responseItem = FilterCustomerResponse.builder().
                    nationalityId(cust.getPartyRole().getParty().getInd().getNatId()).
                    customerId(cust.getCustId()).
                    firstName(cust.getPartyRole().getParty().getInd().getFrstName()).
                    secondName(cust.getPartyRole().getParty().getInd().getMName()).
                    lastName(cust.getPartyRole().getParty().getInd().getLstName()).
                    roleName(cust.getPartyRole().getPartyRoleTp().getName()).
                    build();
            responses.add(responseItem);
        }
        //FR8
        if (responses.size() > 0) {
            return new SuccessDataResult<>(responses, messageSourceService.getMessage(Messages.Customer.SUCCESS_CUST_FILTER));
        }
        return new ErrorDataResult<>(responses, messageSourceService.getMessage(Messages.Customer.ERROR_CUST_FILTER));
    }

    @Override
    public Cust getCustById(Long custId) {
        return this.customerRepository.findById(custId).get();
    }

    private void checkProductIsExist(Cust deleteCustomer) {
        if (deleteCustomer.getCustAccts().stream().anyMatch(custAcct -> custAcct.getCustAcctProdInvls().
                stream().anyMatch(custAcctProdInvl -> custAcctProdInvl.getStId() == StatusCode.CUST_ACCT_PROD_INVL_ACTV))) {
            throw new BusinessException(messageSourceService.getMessage(Messages.Customer.PRE_CHECK_CUST_DELETE));
        }
    }
    private Cust createCust() {
        return Cust.builder().
                stId(StatusCode.CUST_ACTV).
                custTp(customerTypeService.getById(CustomerTypes.PRVT)).
                build();
    }

    private UpdateCustomerResponse UpdateCustomerResponseBuilder(UpdateCustomerRequest updateCustomerRequest,Cust createCust){
        UpdateCustomerResponse response = UpdateCustomerResponse.builder()
                .custId(createCust.getCustId())
                .firstName(updateCustomerRequest.getFirstName())
                .middleName(updateCustomerRequest.getMiddleName())
                .lastName(updateCustomerRequest.getLastName())
                .birthDate(updateCustomerRequest.getBirthDate())
                .motherName(updateCustomerRequest.getMotherName())
                .fatherName(updateCustomerRequest.getFatherName())
                .gender(updateCustomerRequest.getGender())
                .nationalityId(Long.parseLong(updateCustomerRequest.getNationalityId()))
                .build();
        return response;
    }

    //FR9-FR11
    private CreateCustomerResponse CreateCustomerResponseBuilder(CreateCustomerRequest createCustomerRequest,Cust createCust){
        CreateCustomerResponse response = CreateCustomerResponse.builder()
                .customerId(createCust.getCustId())
                .firstName(createCustomerRequest.getFirstName())
                .lastName(createCustomerRequest.getLastName())
                .middleName(createCustomerRequest.getMiddleName())
                .motherName(createCustomerRequest.getMotherName())
                .fatherName(createCustomerRequest.getFatherName())
                .birthDate(createCustomerRequest.getBirthDate())
                .gender(createCustomerRequest.getGender())
                .nationalityId(Long.parseLong(createCustomerRequest.getNationalityId()))
                .addressWhenCreateCustomerRequests(createCustomerRequest.getAddressWhenCreateCustomerRequests())
                .email(createCustomerRequest.getEmail())
                .fax(createCustomerRequest.getFax())
                .email(createCustomerRequest.getEmail())
                .homePhone(createCustomerRequest.getHomePhone())
                .mobilePhone(createCustomerRequest.getMobilePhone())
                .build();
        return response;
    }




}
