package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;


public interface IIndividualService {
    Ind createIndividual(CreateCustomerRequest createCustomerRequest);
    Ind getById(Long natId);
    void existsByNatId(Long natId);
    void save(Ind ind);
    //Result update(UpdateIndividualRequest updateIndividualRequest);
    void updateIndividual(Ind ind, UpdateCustomerRequest updateCustomerRequest);



}
