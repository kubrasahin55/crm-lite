package com.etiya.crmlite.services.responses.common.rsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetResourceSpesificationResponse {
    private Long rsrcSpecId;

    private String name;

    private String descr;

    private Long stId;

    private String rsrcCode;
}
