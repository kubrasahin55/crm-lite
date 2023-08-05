package com.etiya.crmlite.services.responses.order.custOrd;

import com.etiya.crmlite.entities.concretes.order.CustOrdCharVal;
import com.etiya.crmlite.entities.concretes.order.CustOrdItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerOrderResponse {
    private Long custOrdId;

    private Long OrdStId;

    private Long custId;

    private Long bsnInterId;

    private Long bsnInterSpecId;

}
