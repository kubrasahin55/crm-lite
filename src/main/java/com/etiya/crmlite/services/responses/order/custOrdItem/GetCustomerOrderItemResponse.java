package com.etiya.crmlite.services.responses.order.custOrdItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerOrderItemResponse {
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
