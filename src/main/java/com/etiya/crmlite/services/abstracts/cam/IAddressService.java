package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.services.requests.cam.addr.*;
import com.etiya.crmlite.services.requests.cam.cust.CreateAddressWhenCreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;
import com.etiya.crmlite.services.responses.cam.addr.CreateAddressResponse;
import com.etiya.crmlite.services.responses.cam.addr.GetAddressResponse;
import com.etiya.crmlite.services.responses.cam.addr.GetAllAddressResponse;
import com.etiya.crmlite.services.responses.cam.addr.UpdateAddressResponse;

import java.util.List;

public interface IAddressService {
    DataResult<List<Addr>> getAll();

    void addAddress(CreateAddressWhenCreateCustomerRequest createAddressWhenCreateCustomerRequest, Party party);

    void save(Addr addr);

    DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest);
    Result delete(DeleteAddressRequest deleteAddressRequest);
    DataResult<CreateAddressResponse> addCustomerAddress(CreateAddressRequest createAddressRequest);
     Addr addAccountAddress(CreateAccountAddressRequest createAccountAddressRequest, Long accountId);
    void addProductAddress(CreateProductAddressRequest createProductAddressRequest, Long productId);
    Addr getProductAddress(Long productId);
}
