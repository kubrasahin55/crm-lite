package com.etiya.crmlite.services.responses.prod.prodSpec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductSpecificationResponse {
    private Long prodSpecId;

    private String name;

    private String descr;

    private int isDev;
}
