package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.services.requests.cam.custAcct.CreateCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.DeleteCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.UpdateCustomerAccountRequest;
import com.etiya.crmlite.services.responses.cam.custAcct.CreateCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.GetCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.UpdateCustomerAccountResponse;

import javax.xml.crypto.Data;
import java.util.List;

public interface ICustomerAccountService {
   // CustAcct findByCustAcctId(Long custId);

    DataResult<List<GetCustomerAccountResponse>> getAllByCustomerId(Long customerId);

    DataResult<CreateCustomerAccountResponse> add(CreateCustomerAccountRequest createCustomerAccountRequest);

    void addCustomerAccountWhenCustomerCreation(Cust cust);

    DataResult<UpdateCustomerAccountResponse> update(UpdateCustomerAccountRequest updateCustomerAccountRequest);
    Result delete(DeleteCustomerAccountRequest deleteCustomerAccountRequest);


}
