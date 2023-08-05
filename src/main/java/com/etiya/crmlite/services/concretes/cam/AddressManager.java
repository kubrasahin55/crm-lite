package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.ActivationStatus;
import com.etiya.crmlite.core.utilities.enums.TypeValues;
import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.repositories.cam.IAddressRepository;
import com.etiya.crmlite.services.abstracts.cam.ICustomerService;
import com.etiya.crmlite.services.constants.Messages;
import com.etiya.crmlite.services.requests.cam.addr.*;
import com.etiya.crmlite.services.requests.cam.cust.CreateAddressWhenCreateCustomerRequest;
import com.etiya.crmlite.services.responses.cam.addr.CreateAddressResponse;
import com.etiya.crmlite.services.responses.cam.addr.UpdateAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressManager implements IAddressService {
    private  IAddressRepository addressRepository;
    private  ICustomerService customerService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public AddressManager(IAddressRepository addressRepository, @Lazy ICustomerService customerService, IMessageSourceService messageSourceService) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
        this.messageSourceService = messageSourceService;
    }

    //Create address when create a customer
    //FR11
    @Override
    public void addAddress(CreateAddressWhenCreateCustomerRequest createAddressWhenCreateCustomerRequest, Party party) {
       Addr createCustomerAddress=Addr.builder()
               .cntryName(createAddressWhenCreateCustomerRequest.getCountryName())
               .cityName(createAddressWhenCreateCustomerRequest.getCity())
               .strtName(createAddressWhenCreateCustomerRequest.getStreetName())
               .addrDesc(createAddressWhenCreateCustomerRequest.getAdressDescription())
               .bldgId(createAddressWhenCreateCustomerRequest.getFlatNumber())
               .rowId(party.getPartyId())
               .dataTpId(TypeValues.PARTY)
               .isActv(ActivationStatus.ACTIVE)
               .build();
        save(createCustomerAddress);
    }

    @Override
    public DataResult<CreateAddressResponse> addCustomerAddress(CreateAddressRequest createAddressRequest) {
        Cust cust = this.customerService.getCustById(createAddressRequest.getCustomerId());
        Addr createAddress = Addr.builder()
                .cityName(createAddressRequest.getCityName())
                .strtName(createAddressRequest.getStreetName())
                .addrDesc(createAddressRequest.getAddrDescription())
                .bldgName(createAddressRequest.getBuildingName())
                .rowId(cust.getPartyRole().getParty().getPartyId())
                .dataTpId(TypeValues.PARTY)
                .isActv(ActivationStatus.ACTIVE)
                .build();
        this.addressRepository.save(createAddress);
        CreateAddressResponse response = CreateAddressResponseBuilder(createAddressRequest);
        return new SuccessDataResult<>(response, messageSourceService.
                getMessage(Messages.Address.SUCCESS_CUST_ADDR_CREATE)) ;
    }
    @Override
    public Addr addAccountAddress(CreateAccountAddressRequest createAccountAddressRequest
            , Long accountId) {
        Addr createAddress = Addr.builder()
                .cityName(createAccountAddressRequest.getCityName())
                .strtName(createAccountAddressRequest.getStreetName())
                .addrDesc(createAccountAddressRequest.getAddrDescripton())
                .bldgName(createAccountAddressRequest.getBuildingName())

                .rowId(accountId)
                .dataTpId(TypeValues.CUST_ACCT)
                .isActv(ActivationStatus.ACTIVE)
                .build();
        return this.addressRepository.save(createAddress);

    }
    @Override
    public void addProductAddress(CreateProductAddressRequest createProductAddressRequest, Long productId) {
        Addr createAddress = Addr.builder()
                .cityName(createProductAddressRequest.getCityName())
                .strtName(createProductAddressRequest.getStreetName())
                .addrDesc(createProductAddressRequest.getAddrDescription())
                .bldgName(createProductAddressRequest.getBuildingName())
                .rowId(productId)
                .dataTpId(TypeValues.PROD)
                .isActv(ActivationStatus.ACTIVE)
                .build();
        this.addressRepository.save(createAddress);

    }

    @Override
    public DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest) {
        Addr addrUpdate = addressRepository.findById(updateAddressRequest.getAddressId()).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.Address.ERROR_CUST_ADDR_UPDATE));
        });
        addrUpdate.setCityName(updateAddressRequest.getCityName());
        addrUpdate.setBldgId(updateAddressRequest.getBldgId());
        addrUpdate.setAddrDesc(updateAddressRequest.getAddrDesc());
        addrUpdate.setCntryName(updateAddressRequest.getCntryName());
        addrUpdate.setStrtName(updateAddressRequest.getStrtName());

        this.addressRepository.save(addrUpdate);
        UpdateAddressResponse response = UpdateAddressResponseBuilder(updateAddressRequest);
        return new SuccessDataResult(messageSourceService.getMessage(Messages.Address.SUCCESS_CUST_ADDR_UPDATE));
    }

    @Override
    public Result delete(DeleteAddressRequest deleteAddressRequest) {
        Addr deleteAddress = this.addressRepository.findById(deleteAddressRequest.getAddressId()).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.Address.ERROR_CUST_ADDR_DELETE));
        });;
        if(deleteAddress.getDataTpId() == TypeValues.PARTY){
            checkOnlyOneAddress(deleteAddress);
        }
        deleteAddress.setIsActv(ActivationStatus.INACTIVE);
        this.addressRepository.save(deleteAddress);
        return new SuccessResult(messageSourceService.getMessage(Messages.Address.SUCCESS_CUST_ADDR_DELETE));
    }

    @Override
    public DataResult<List<Addr>> getAll() {
        return new SuccessDataResult<>(this.addressRepository.findAll());
    }

    @Override
    public Addr getProductAddress(Long productId) {
        return this.addressRepository.findAllByRowIdAndDataTpIdAndIsActv(productId, TypeValues.PROD, ActivationStatus.ACTIVE)
                .stream().findFirst().orElseThrow();
    }

    @Override
    public void save(Addr addr){
        this.addressRepository.save(addr);
    }

    private void checkOnlyOneAddress(Addr deleteAddress){
        List<Addr> deletedAddresses = this.addressRepository.findAllByRowIdAndDataTpIdAndIsActv(deleteAddress.getRowId(),
                deleteAddress.getDataTpId(), ActivationStatus.ACTIVE);
        if(deletedAddresses.size() <= 1) throw new BusinessException(messageSourceService.getMessage(Messages.Address.CUST_DOESNT_HAVE_AN_ADDRESS));
    }

    private CreateAddressResponse CreateAddressResponseBuilder(CreateAddressRequest createAddressRequest){
        CreateAddressResponse response = CreateAddressResponse.builder()
                .addrDescription(createAddressRequest.getAddrDescription())
                .cityName(createAddressRequest.getCityName())
                .streetName(createAddressRequest.getStreetName())
                .buildingName(createAddressRequest.getBuildingName())
                .customerId(createAddressRequest.getCustomerId())
                .build();
        return response;
    }

    private UpdateAddressResponse UpdateAddressResponseBuilder(UpdateAddressRequest updateAddressRequest){
        UpdateAddressResponse response = UpdateAddressResponse.builder()
                .addressId(updateAddressRequest.getAddressId())
                .cntryName(updateAddressRequest.getCntryName())
                .bldgId(updateAddressRequest.getBldgId())
                .cityName(updateAddressRequest.getCityName())
                .strtName(updateAddressRequest.getStrtName())
                .addrDesc(updateAddressRequest.getAddrDesc())
                .build();
        return response;
    }
}
