package com.etiya.crmlite.services.responses.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private Long custId;

    private Long stId;

    private Long custTpId;
}
