package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.services.abstracts.cam.ICustomerAccountProductInvolvementService;
import com.etiya.crmlite.services.constants.Paths;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetAllCustomerAccountProductInvolvementResponse;
import com.etiya.crmlite.services.responses.cam.custAcctProdInvl.GetCustomerAccountProductInvolvementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "customer-account-product-involvement")
public class CustomerAccountProductInvolvementController {

    private ICustomerAccountProductInvolvementService customerAccountProductInvolvementService;
    @Autowired
    public CustomerAccountProductInvolvementController(ICustomerAccountProductInvolvementService customerAccountProductInvolvementService) {
        this.customerAccountProductInvolvementService = customerAccountProductInvolvementService;
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllCustomerAccountProductInvolvementResponse>> getAll(@RequestParam Long customerAccountId){
        return this.customerAccountProductInvolvementService.getAll(customerAccountId);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetCustomerAccountProductInvolvementResponse> getById(@RequestParam Long custAcctProdInvlId){
        return this.customerAccountProductInvolvementService.getById(custAcctProdInvlId);
    }
}
