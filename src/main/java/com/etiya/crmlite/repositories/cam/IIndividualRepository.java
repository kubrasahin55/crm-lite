package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Ind;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIndividualRepository extends JpaRepository<Ind,Long> {
    boolean existsByNatId(Long natId);
}
