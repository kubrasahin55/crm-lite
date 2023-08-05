package com.etiya.crmlite.services.responses.cam.custTp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerTypeResponse {
    private Long custTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

}
