package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.StatusCode;

import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.repositories.cam.IIndividualRepository;
import com.etiya.crmlite.services.abstracts.cam.IIndividualService;
import com.etiya.crmlite.services.constants.Messages;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import com.etiya.crmlite.services.requests.cam.cust.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndividualManager implements IIndividualService {

    private IIndividualRepository individualRepository;
    private IMessageSourceService messageSourceService;

    @Autowired
    public IndividualManager(IIndividualRepository individualRepository, IMessageSourceService messageSourceService) {
        this.individualRepository = individualRepository;
        this.messageSourceService = messageSourceService;
    }

    //FR4
    @Override
    public Ind createIndividual(CreateCustomerRequest createCustomerRequest) {
        existsByNatId(Long.parseLong(createCustomerRequest.getNationalityId()));
        return Ind.builder()
                .frstName(createCustomerRequest.getFirstName())
                .lstName(createCustomerRequest.getLastName())
                .mName(createCustomerRequest.getMiddleName())
                .brthDate(createCustomerRequest.getBirthDate())
                .gendrId(createCustomerRequest.getGender())
                .mthrName(createCustomerRequest.getMotherName())
                .fthrName(createCustomerRequest.getFatherName())
                .natId(Long.parseLong(createCustomerRequest.getNationalityId()))
                .stId(StatusCode.IND_ACTV)
                .build();
    }

    @Override
    public Ind getById(Long indId) {
        return this.individualRepository.findById(indId).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.Individual.ERROR_IND_GET));
        });
    }

    @Override
    public void save(Ind ind) {
        this.individualRepository.save(ind);
    }

    @Override
    public void updateIndividual(Ind ind, UpdateCustomerRequest updateCustomerRequest) {
        existsByNatId(Long.parseLong(updateCustomerRequest.getNationalityId()));
        ind.setFrstName(updateCustomerRequest.getFirstName());
        ind.setMName(updateCustomerRequest.getMiddleName());
        ind.setLstName(updateCustomerRequest.getLastName());
        ind.setBrthDate(updateCustomerRequest.getBirthDate());
        ind.setGendrId(updateCustomerRequest.getGender());
        ind.setMthrName(updateCustomerRequest.getMotherName());
        ind.setFthrName(updateCustomerRequest.getFatherName());
        ind.setNatId(Long.parseLong(updateCustomerRequest.getNationalityId()));
        this.individualRepository.save(ind);
    }

    //FR12
    @Override
    public void existsByNatId(Long natId) {
        boolean isExists = individualRepository.existsByNatId(natId);
        if (isExists) {
            throw new BusinessException(messageSourceService.getMessage(Messages.Individual.IS_NAT_ID_EXIST));
        }
    }
}



