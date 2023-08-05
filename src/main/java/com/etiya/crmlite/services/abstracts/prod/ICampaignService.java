package com.etiya.crmlite.services.abstracts.prod;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.prod.Cmpg;
import com.etiya.crmlite.services.responses.prod.cmpg.GetAllCampaignResponse;
import com.etiya.crmlite.services.responses.prod.cmpg.GetCampaignResponse;

import java.util.List;

public interface ICampaignService {
    Cmpg getCmpgById(Long cmpgId);
}
