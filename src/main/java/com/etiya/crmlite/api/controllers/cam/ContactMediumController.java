package com.etiya.crmlite.api.controllers.cam;

import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.constants.Paths;
import com.etiya.crmlite.services.requests.cam.cntcMedium.UpdateCustomerContactMediumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix + "contact-medium")
public class ContactMediumController {
    private IContactMediumService contactMediumService;

    @Autowired
    public ContactMediumController(IContactMediumService contactMediumService) {
        this.contactMediumService = contactMediumService;
    }

    //Request Body Ekleyince Patlıyor (update)
    @PutMapping("/update-customer-contact-medium")
    public Result update(@RequestBody @Valid UpdateCustomerContactMediumRequest updateCustomerContactMediumRequest){
         return this.contactMediumService.updateCustomerContactMedium(updateCustomerContactMediumRequest);
     }
}
