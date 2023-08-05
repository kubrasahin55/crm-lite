package com.etiya.crmlite.services.responses.order.custOrdCharVal;

import com.etiya.crmlite.entities.concretes.order.CustOrd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerOrderCharacteristicValueResponse {
    private Long custOrdCharValId;

    private Long custOrdId;

    private Long charId;

    private Long charValId;

    private String val;

    private int isActv;
}
