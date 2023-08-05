package com.etiya.crmlite.repositories.prod;

import com.etiya.crmlite.entities.concretes.prod.ProdSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSpecificationRepository extends JpaRepository<ProdSpec,Long> {
}
