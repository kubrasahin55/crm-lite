package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.abstracts.cam.ICustomerAccountService;
import com.etiya.crmlite.services.constants.Paths;
import com.etiya.crmlite.services.requests.cam.custAcct.CreateCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.DeleteCustomerAccountRequest;
import com.etiya.crmlite.services.requests.cam.custAcct.UpdateCustomerAccountRequest;
import com.etiya.crmlite.services.responses.cam.custAcct.CreateCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.GetCustomerAccountResponse;
import com.etiya.crmlite.services.responses.cam.custAcct.UpdateCustomerAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "customer-account")
public class CustomerAccountController {

    private ICustomerAccountService customerAccountService;

    @Autowired
    public CustomerAccountController(ICustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @PostMapping("/add-customer-billing-account")
    public ResponseEntity<DataResult<CreateCustomerAccountResponse>> add(@RequestBody @Valid CreateCustomerAccountRequest createCustomerAccountRequest){
        return new ResponseEntity<>(this.customerAccountService.add(createCustomerAccountRequest), HttpStatus.CREATED);
    }
    @PutMapping("/update-customer-account")
    public ResponseEntity<DataResult<UpdateCustomerAccountResponse>> update(@RequestBody @Valid UpdateCustomerAccountRequest updateCustomerAccountRequest){
        return new ResponseEntity<> (this.customerAccountService.update(updateCustomerAccountRequest), HttpStatus.OK);
    }
    @PostMapping("/delete-customer-account")
    public Result delete(@RequestBody DeleteCustomerAccountRequest deleteCustomerAccountRequest){
        return  this.customerAccountService.delete(deleteCustomerAccountRequest);
    }

    @GetMapping("/get-by-customer-id")
    public DataResult<List<GetCustomerAccountResponse>> findAllByCustomerId(@RequestParam Long customerId){
        return this.customerAccountService.getAllByCustomerId(customerId);
    }
}
