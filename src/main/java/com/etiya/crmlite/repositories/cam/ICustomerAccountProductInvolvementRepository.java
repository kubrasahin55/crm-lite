package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerAccountProductInvolvementRepository extends JpaRepository<CustAcctProdInvl, Long> {
    List<CustAcctProdInvl> findAllByCustAcctCustAcctId(Long custAcctId);
}
