package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetAllCustomerAccountProductInvolvementResponse;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetCustomerAccountProductInvolvementResponse;

import java.util.List;

public interface ICustomerAccountProductInvolvementService {
    DataResult<List<GetAllCustomerAccountProductInvolvementResponse>> getAll(Long custAcctId);
    DataResult<GetCustomerAccountProductInvolvementResponse> getById(Long custAcctProdInvlId);
}
