package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.DeleteCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.FilterCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;
import com.etiya.crmlite.services.responses.cam.cust.CreateCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.FilterCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.UpdateCustomerResponse;

import java.util.List;


public interface ICustomerService {
    DataResult<List<FilterCustomerResponse>> filter(FilterCustomerRequest filterCustomerRequest);
    DataResult<CreateCustomerResponse> add(CreateCustomerRequest createCustomerRequest);

    DataResult<UpdateCustomerResponse> update(UpdateCustomerRequest updateCustomerRequest);
    Result delete(DeleteCustomerRequest deleteCustomerRequest);
    Cust getCustById(Long custId);

}
