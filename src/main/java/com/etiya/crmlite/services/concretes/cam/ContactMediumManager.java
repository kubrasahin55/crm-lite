package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.ContactMediumTypes;
import com.etiya.crmlite.core.utilities.enums.GeneralTypes;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.enums.TypeValues;
import com.etiya.crmlite.core.utilities.results.Result;
import com.etiya.crmlite.core.utilities.results.SuccessResult;
import com.etiya.crmlite.entities.concretes.cam.CntcMedium;
import com.etiya.crmlite.repositories.cam.IContactMediumRepository;
import com.etiya.crmlite.services.abstracts.cam.IContactMediumService;
import com.etiya.crmlite.services.requests.cam.cntcMedium.CreateContactMediumRequest;
import com.etiya.crmlite.services.requests.cam.cntcMedium.UpdateCustomerContactMediumRequest;
import com.etiya.crmlite.services.requests.cam.cust.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactMediumManager implements IContactMediumService {
    private IContactMediumRepository contactMediumRepository;


    @Autowired
    public ContactMediumManager(IContactMediumRepository contactMediumRepository) {
        this.contactMediumRepository = contactMediumRepository;

    }

    @Override
    public Result addContactMedium(CreateContactMediumRequest createContactMediumRequest) {
        CntcMedium createContactMedium = CntcMedium.builder()
                .cntcData(createContactMediumRequest.getCntcData())
                .cntcMediumTpId(createContactMediumRequest.getCntcMediumTpId())
                .rowId(createContactMediumRequest.getRowId())
                .dataTpId(createContactMediumRequest.getDataTpId())
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();
        return new SuccessResult();
    }

    @Override
    public void createContactMediumWhenCustomerCreation(CreateCustomerRequest createCustomerRequest, Long partyId) {
        List<CntcMedium> cntcMediumList = new ArrayList<>();
        CntcMedium email = createCntcMedium(partyId, ContactMediumTypes.EML, createCustomerRequest.getEmail());
        CntcMedium mobilePhone = createCntcMedium(partyId, ContactMediumTypes.GSM, createCustomerRequest.getMobilePhone());
        CntcMedium fax = createCntcMedium(partyId, ContactMediumTypes.FAX, createCustomerRequest.getFax());
        CntcMedium homePhone = createCntcMedium(partyId, ContactMediumTypes.PSTN, createCustomerRequest.getMobilePhone());
        cntcMediumList.add(email);
        cntcMediumList.add(mobilePhone);
        cntcMediumList.add(fax);
        cntcMediumList.add(homePhone);
        this.contactMediumRepository.saveAll(cntcMediumList);
    }

    @Override
    public Result updateCustomerContactMedium(UpdateCustomerContactMediumRequest updateCustomerContactMediumRequest) {
        CntcMedium updatedPstn = getByRowIdAndCntcMediumTpId(updateCustomerContactMediumRequest, GeneralTypes.PSTN);
        updatedPstn.setCntcData(updateCustomerContactMediumRequest.getHomePhone());
        CntcMedium updatedFax = getByRowIdAndCntcMediumTpId(updateCustomerContactMediumRequest, GeneralTypes.FAX);
        updatedFax.setCntcData(updateCustomerContactMediumRequest.getFax());
        CntcMedium updatedGsmNumber = getByRowIdAndCntcMediumTpId(updateCustomerContactMediumRequest, GeneralTypes.GSM);
        updatedGsmNumber.setCntcData(updateCustomerContactMediumRequest.getMobilePhone());
        CntcMedium updatedEmail = getByRowIdAndCntcMediumTpId(updateCustomerContactMediumRequest, GeneralTypes.EML);
        updatedEmail.setCntcData(updateCustomerContactMediumRequest.getEmail());

        List<CntcMedium> updatedContactList = new ArrayList<>();
        updatedContactList.add(updatedPstn);
        updatedContactList.add(updatedFax);
        updatedContactList.add(updatedGsmNumber);
        updatedContactList.add(updatedEmail);

        contactMediumRepository.saveAll(updatedContactList);
        updateCustomerContactMediumRequestBuilder(updateCustomerContactMediumRequest, updatedPstn, updatedFax, updatedGsmNumber, updatedEmail);
        return new SuccessResult();
    }
    private UpdateCustomerContactMediumRequest updateCustomerContactMediumRequestBuilder(UpdateCustomerContactMediumRequest updateCustomerContactMediumRequestBuilder, CntcMedium updatedPstn, CntcMedium updatedFax, CntcMedium updatedGsmNumber, CntcMedium updatedEmail) {
        return UpdateCustomerContactMediumRequest.builder()
                .partyId(updateCustomerContactMediumRequestBuilder.getPartyId())
                .homePhone(updateCustomerContactMediumRequestBuilder.getHomePhone())
                .fax(updateCustomerContactMediumRequestBuilder.getFax())
                .email(updateCustomerContactMediumRequestBuilder.getEmail())
                .mobilePhone(updateCustomerContactMediumRequestBuilder.getMobilePhone())
                .build();

    }

    private CntcMedium getByRowIdAndCntcMediumTpId(UpdateCustomerContactMediumRequest updateCustomerContactMediumRequest, Long cntcMediumTp) {
        return contactMediumRepository.findByRowIdAndCntcMediumTpId(updateCustomerContactMediumRequest.getPartyId(), cntcMediumTp);
    }

    private CntcMedium createCntcMedium(Long rowId, Long contactMediumType, String contactData) {
        return CntcMedium.builder()
                .rowId(rowId)
                .cntcMediumTpId(contactMediumType)
                .cntcData(contactData)
                .dataTpId(TypeValues.PARTY)
                .stId(StatusCode.CNTC_MEDIUM_ACTV)
                .build();
    }
}
