package com.etiya.crmlite.repositories.prod;

import com.etiya.crmlite.entities.concretes.prod.ProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOfferingRepository extends JpaRepository<ProdOfr,Long> {
}
