package com.etiya.crmlite.services.responses.cam.custAcctProdInvl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllCustomerAccountProductInvolvementResponse {
    private Long custAcctProdInvlId;

    private Long productId;

    private String productName;

    private Long campaignId;

    private String campaignName;

}
