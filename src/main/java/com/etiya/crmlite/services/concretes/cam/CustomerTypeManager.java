package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.repositories.cam.ICustomerTypeRepository;
import com.etiya.crmlite.services.abstracts.cam.ICustomerTypeService;
import com.etiya.crmlite.services.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeManager implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository;
    private IMessageSourceService messageSourceService;

    @Autowired
    public CustomerTypeManager(ICustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public CustTp getById(Long custTpId) {
        return this.customerTypeRepository.findById(custTpId).orElseThrow(() -> {
            throw new BusinessException(messageSourceService.getMessage
                    (Messages.CustomerType.ERROR_CUST_TP_GET));
        });
    }
}
