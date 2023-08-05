package com.etiya.crmlite.api.controllers.cam;


import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.abstracts.cam.IAddressService;
import com.etiya.crmlite.services.constants.Paths;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.services.requests.cam.addr.CreateAddressRequest;
import com.etiya.crmlite.services.requests.cam.addr.DeleteAddressRequest;
import com.etiya.crmlite.services.requests.cam.addr.UpdateAddressRequest;
import com.etiya.crmlite.services.responses.cam.addr.CreateAddressResponse;
import com.etiya.crmlite.services.responses.cam.addr.UpdateAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "address")
public class AddressController {
    private IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<CreateAddressResponse>> add(@RequestBody @Valid CreateAddressRequest createAddressRequest)
    {
        return new ResponseEntity<>(this.addressService.addCustomerAddress(createAddressRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update-customer-address")
    public ResponseEntity<DataResult<UpdateAddressResponse>> update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest){
        return new ResponseEntity<>(this.addressService.updateAddress(updateAddressRequest), HttpStatus.OK);
    }

    @PostMapping("/delete-address")
    public Result delete(@RequestBody DeleteAddressRequest deleteAddressRequest){
        return addressService.delete(deleteAddressRequest);
    }

    @GetMapping("/get-all-address")
    public DataResult<List<Addr>> getAll() {
        return this.addressService.getAll();
    }

}
