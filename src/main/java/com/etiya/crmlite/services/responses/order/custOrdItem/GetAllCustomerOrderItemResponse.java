package com.etiya.crmlite.services.responses.order.custOrdItem;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import com.etiya.crmlite.entities.concretes.order.CustOrd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerOrderItemResponse {
    private Long custOrdItemId;

    private Long custOrdId;

    private Long custAcctId;

    private Long newCustAcctId;

    private Long prodId;

    private Long prodOfrId;

    private Long bsnInterId;

    private Long cmpgId;

    private int isNeedShpmt;

    private String ofrName;

    private String prodName;

    private Long prodSpecId;

    private Long custId;

    private Long newCustId;

    private String cmpgName;
}
