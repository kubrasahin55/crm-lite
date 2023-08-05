package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.core.utilities.enums.ActivationStatus;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Addr, Long> {
    List<Addr> findAllByRowIdAndDataTpIdAndIsActv(Long rowId, Long dataTpId, int isActv);
}
