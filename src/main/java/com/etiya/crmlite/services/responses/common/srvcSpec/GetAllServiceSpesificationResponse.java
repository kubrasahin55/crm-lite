package com.etiya.crmlite.services.responses.common.srvcSpec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllServiceSpesificationResponse {
    private Long srvcSpecId;

    private String name;

    private String descr;

    private String srvcCode;

    private Long stId;

}
