package com.etiya.crmlite.services.responses.order.custOrd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerOrderResponse {
    private Long custOrdId;

    private Long OrdStId;

    private Long custId;

    private Long bsnInterId;

    private Long bsnInterSpecId;
}
