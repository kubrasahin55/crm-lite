package com.etiya.crmlite.services.concretes.prod;


import com.etiya.crmlite.entities.concretes.prod.Cmpg;
import com.etiya.crmlite.repositories.prod.ICampaignRepository;
import com.etiya.crmlite.services.abstracts.prod.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CampaignManager implements ICampaignService{
    private ICampaignRepository campaignRepository;

    @Autowired
    public CampaignManager(ICampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Cmpg getCmpgById(Long cmpgId) {
        return this.campaignRepository.findById(cmpgId).orElseThrow();
    }
}
