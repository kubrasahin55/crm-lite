package com.etiya.crmlite.services.abstracts.common;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.common.GnlSt;
import com.etiya.crmlite.services.responses.common.gnlSt.GetAllGeneralStatusResponse;

import java.util.List;

public interface IGeneralStatusService {
    DataResult<List<GetAllGeneralStatusResponse>> getAll();
    GnlSt findById(Long gnlStId);
}
