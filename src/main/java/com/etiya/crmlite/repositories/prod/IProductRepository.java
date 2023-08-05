package com.etiya.crmlite.repositories.prod;

import com.etiya.crmlite.entities.concretes.prod.Prod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Prod,Long> {
}
