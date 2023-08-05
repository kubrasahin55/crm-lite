package com.etiya.crmlite.services.abstracts.common;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.common.GnlTp;
import com.etiya.crmlite.services.responses.common.gnlTp.GetAllGeneralTypeResponse;

import java.util.List;

public interface IGeneralTypeService {
    DataResult<List<GetAllGeneralTypeResponse>> getAll();
    GnlTp findById(long gnlTpId);
}
