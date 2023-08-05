package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.abstracts.cam.ICustomerService;
import com.etiya.crmlite.services.constants.Paths;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.DeleteCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.FilterCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;
import com.etiya.crmlite.services.responses.cam.cust.CreateCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.FilterCustomerResponse;
import com.etiya.crmlite.services.responses.cam.cust.UpdateCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "customer")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/filter-customer")
    public  ResponseEntity<DataResult<List<FilterCustomerResponse>>>  filter(@RequestBody FilterCustomerRequest filterCustomerRequest) {
        return  new ResponseEntity<> (this.customerService.filter(filterCustomerRequest),HttpStatus.OK);
    }

    @PostMapping("/create-customer")
    public ResponseEntity<DataResult<CreateCustomerResponse>> add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        return new ResponseEntity<>  (this.customerService.add(createCustomerRequest), HttpStatus.CREATED);
    }
    @PutMapping("/update-customer")
    public ResponseEntity<DataResult<UpdateCustomerResponse>> update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        return new ResponseEntity<> (this.customerService.update(updateCustomerRequest),HttpStatus.OK);
    }

    @PostMapping("/delete-customer")
    public Result delete(DeleteCustomerRequest deleteCustomerRequest){
        return this.customerService.delete(deleteCustomerRequest);
    }

}
