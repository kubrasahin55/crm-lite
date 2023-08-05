package com.etiya.crmlite.repositories.order;

import com.etiya.crmlite.entities.concretes.order.CustOrdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerOrderCharacteristicValueRepository extends JpaRepository<CustOrdCharVal,Long> {
}
