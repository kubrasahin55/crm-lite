package com.etiya.crmlite.services.concretes.common;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlTp;
import com.etiya.crmlite.repositories.common.IGeneralTypeRepository;
import com.etiya.crmlite.services.abstracts.common.IGeneralTypeService;
import com.etiya.crmlite.services.responses.common.gnlTp.GetAllGeneralTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralTypeManager implements IGeneralTypeService {
    private final IGeneralTypeRepository generalTypeRepository;

    @Autowired
    public GeneralTypeManager(IGeneralTypeRepository generalTypeRepository) {
        this.generalTypeRepository = generalTypeRepository;
    }

    @Override
    public DataResult<List<GetAllGeneralTypeResponse>> getAll() {
        List<GnlTp> result=this.generalTypeRepository.findAll();
        List<GetAllGeneralTypeResponse> response=result.stream().map(gnlTp -> GetAllGeneralTypeResponse.builder()
                        .generalTypeId(gnlTp.getGnlTpId())
                        .name(gnlTp.getName())
                        .description(gnlTp.getDescr())
                        .isActive(gnlTp.getIsActv())
                        .entCodeName(gnlTp.getEntCodeName())
                        .entName(gnlTp.getEntName())
                        .build())
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response);
    }

    @Override
    public GnlTp findById(long gnlTpId) {
        return this.generalTypeRepository.findById(gnlTpId)
                .orElseThrow(()->{throw new RuntimeException("General Type with the given ID cannot be found.");});
    }
}
