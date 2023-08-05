//package com.etiya.crmlite.services.concretes.cam;
//
//import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
//import com.etiya.crmlite.core.utilities.messages.MessageSourceManager;
//import com.etiya.crmlite.entities.concretes.cam.Cust;
//import com.etiya.crmlite.entities.concretes.cam.CustAcct;
//import com.etiya.crmlite.repositories.cam.ICustomerAccountRepository;
//import com.etiya.crmlite.repositories.cam.ICustomerRepository;
//import com.etiya.crmlite.services.abstracts.cam.*;
//import com.etiya.crmlite.services.abstracts.common.IGeneralStatusService;
//import com.etiya.crmlite.services.abstracts.common.IGeneralTypeService;
//import com.etiya.crmlite.services.requests.cam.addr.CreateAccountAddressRequest;
//import com.etiya.crmlite.services.requests.cam.custAcct.CreateCustomerAccountRequest;
//import com.etiya.crmlite.services.responses.cam.custAcct.CreateCustomerAccountResponse;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.support.ResourceBundleMessageSource;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.any;
//
//import static org.mockito.Mockito.mock;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CustomerAccountManagerTest {
////    @Mock
//    ICustomerAccountRepository customerAccountRepository;
//    ICustomerRepository customerRepository;
//    IIndividualService individualService;
//    ICustomerTypeService customerTypeService;
//   IPartyRoleService partyRoleService;
//    IPartyRoleTypeService partyRoleTypeService;
//    IPartyService partyService;
//    IAddressService addressService;
//    IContactMediumService contactMediumService;
//    ICustomerAccountService customerAccountService;
//    IMessageSourceService messageSourceService;
//    ICustomerService customerService;
//    MessageSource messageSource;
//    CustomerAccountManager customerAccountManager;
//    IGeneralStatusService generalStatusService;
//    IGeneralTypeService generalTypeService;
//
//
//    @BeforeEach
//    void setUp() {
//        customerAccountRepository = mock(ICustomerAccountRepository.class);
//        messageSource=getResourceBundle();
//        messageSourceService = new MessageSourceManager(messageSource);
//        customerService = new CustomerManager(customerRepository, individualService, customerTypeService, partyRoleService,
//                partyRoleTypeService, partyService, addressService, contactMediumService, customerAccountService,
//                messageSourceService);
//        addressService = mock(IAddressService.class);
//        customerAccountManager = new CustomerAccountManager(customerAccountRepository, generalStatusService, generalTypeService,
//                customerService, addressService, messageSourceService);
//    }
//
//    ResourceBundleMessageSource getResourceBundle(){
//        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//        source.setBasename("messages");
//        return source;
//    }
//
//    @Test
//    void add() {
//        CreateAccountAddressRequest createAccountAddressRequest = new CreateAccountAddressRequest();
//        createAccountAddressRequest.setCityName("Ankara");
//        createAccountAddressRequest.setBuildingName("strjh");
//        createAccountAddressRequest.setStreetName("asdf");
//        createAccountAddressRequest.setAddrDescripton("fhfggh");
//
//        CreateCustomerAccountRequest createCustomerAccountRequest = new CreateCustomerAccountRequest();
//        createCustomerAccountRequest.setCustomerId(1321L);
//        createCustomerAccountRequest.setAccountName("Fatura Hesabı");
//        createCustomerAccountRequest.setDescription("Fatura Hesabı");
//        createCustomerAccountRequest.setAddressRequest(createAccountAddressRequest);
//
//        Cust cust = Cust.builder()
//                .custId(1321L)
//                .stId(83L)
//                .build();
//
//        Optional<Cust> optionalCust = Optional.of(cust);
//        when(customerRepository.findById(1321L)).thenReturn(optionalCust);
//
//
//        CustAcct custAcct = CustAcct.builder()
//                .acctNo("1321")
//                .acctName("Fatura Hesabı")
//                .stId(164L)
//                .acctTpId(223L)
//                .descr("Fatura Hesabı")
//                .cust(cust)
//                .build();
//
//        when(customerAccountRepository.save(any())).thenReturn(custAcct);
//
//        CreateCustomerAccountResponse response = customerAccountManager.add(createCustomerAccountRequest).getData();
//
//        assert response.getAccountName() == custAcct.getAcctName();
//
//    }
//
//
//
//}