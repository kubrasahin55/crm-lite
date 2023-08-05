package com.etiya.crmlite.services.concretes.common;

import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.common.GnlSt;
import com.etiya.crmlite.repositories.common.IGeneralStatusRepository;
import com.etiya.crmlite.services.abstracts.common.IGeneralStatusService;
import com.etiya.crmlite.services.responses.common.gnlSt.GetAllGeneralStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralStatusManager implements IGeneralStatusService {
    private IGeneralStatusRepository generalStatusRepository;

    @Autowired
    public GeneralStatusManager(IGeneralStatusRepository generalStatusRepository) {
        this.generalStatusRepository = generalStatusRepository;
    }

    @Override
    public DataResult<List<GetAllGeneralStatusResponse>> getAll() {
        List<GnlSt> result = this.generalStatusRepository.findAll();
        List<GetAllGeneralStatusResponse> response = result.stream().map(gnlSt -> GetAllGeneralStatusResponse.builder()
                        .generalStatusId(gnlSt.getGnlStId())
                        .name(gnlSt.getName())
                        .description(gnlSt.getDescr())
                        .isActive(gnlSt.getIsActv())
                        .entCodeName(gnlSt.getEntCodeName())
                        .entName(gnlSt.getEntName())
                        .build())
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }

    @Override
    public GnlSt findById(Long gnlStId) {
        return this.generalStatusRepository.findById(gnlStId)
                .orElseThrow(() -> {
                    throw new RuntimeException("General Status with the given ID cannot be found.");
                });

    }
}
