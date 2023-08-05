package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.services.requests.cam.cntcMedium.CreateContactMediumRequest;
import com.etiya.crmlite.services.requests.cam.cntcMedium.UpdateCustomerContactMediumRequest;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;

public interface IContactMediumService {
    Result addContactMedium(CreateContactMediumRequest createContactMediumRequest);
    void createContactMediumWhenCustomerCreation(CreateCustomerRequest createCustomerRequest, Long partyId);
    Result updateCustomerContactMedium(UpdateCustomerContactMediumRequest updateCustomerContactMediumRequest);
}
