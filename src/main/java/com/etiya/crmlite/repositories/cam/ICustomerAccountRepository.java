package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.CustAcct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerAccountRepository extends JpaRepository<CustAcct, Long> {
   /* @Query(value = "Select CUST_ACCT from CUST_ACCT where  CUST_ID =:custId", nativeQuery = true)
    CustAcct findByCustId(Long custId);*/

    @Query("Select ca from CustAcct ca where ca.cust.custId = :custId")
    List<CustAcct> findAllByCustomerId(@Param("custId") Long custId);

   // CustAcct findByCustId(Long custId);

}
