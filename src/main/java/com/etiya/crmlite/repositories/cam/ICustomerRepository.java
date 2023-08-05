package com.etiya.crmlite.repositories.cam;

import com.etiya.crmlite.entities.concretes.cam.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Cust, Long> {

    //FR 4
    @Query("select DISTINCT c,i "+
            "from Ind i JOIN i.party p " +
            "join p.partyRoles pr " +
            "join  pr.cust c " +
            "join  pr.partyRoleTp prt " +
            "left join c.custAccts acclist " +
            "left join CustOrd co on co.custId = c.custId " +
            "left join CntcMedium cm on (cm.rowId = p.partyId and cm.dataTpId = 9 and cm.cntcMediumTpId = 172) " +
            "left join CntcMedium cm2 on (cm.rowId = c.custId and cm.dataTpId = 13 and cm.cntcMediumTpId = 172) " +
            "where(:nationalityId is null or i.natId =:nationalityId )" +
            "and(:customerId is null or c.custId =:customerId)" +
            "and( :accountNumber is null or acclist.acctNo =:accountNumber )" +
            "and( :gsmNumber is null or cm.cntcData =:gsmNumber or cm2.cntcData=:gsmNumber  )" +
            "and(:firstName is null or(lower(i.frstName) like concat (lower (:firstName ),'%'))) "+
            "and(:customerOrderId is null or (co.custOrdId =:customerOrderId))"+
            "and(:lastName is null or (lower(i.lstName)like concat (lower (:lastName ),'%')))")
    List<Cust> filterCustomers(@Param("nationalityId") Long nationalityId,
                                        @Param("customerId") Long customerId,
                                        @Param("accountNumber") String accountNumber,
                                        @Param("gsmNumber") String gsmNumber,
                                        @Param("firstName") String firstName,
                                        @Param("lastName") String lastName,
                                        @Param("customerOrderId") Long customerOrderId);
}
