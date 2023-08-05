package com.etiya.crmlite.services.responses.cam.custAcctProdInvl;

import com.etiya.crmlite.services.responses.cam.addr.GetAddressResponse;
import com.etiya.crmlite.services.responses.prod.prodCharVal.GetAllProductCharacteristicValueResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCustomerAccountProductInvolvementResponse {
    private Long productOfferId;

    private String productOfferName;

    private Long productSpecificationId;

    private List<GetAllProductCharacteristicValueResponse> productCharacteristics;

    private GetAddressResponse serviceAddress;
}
