package com.etiya.crmlite.repositories.prod;

import com.etiya.crmlite.entities.concretes.prod.ProdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCharacteristicValueRepository extends JpaRepository<ProdCharVal,Long> {
}
