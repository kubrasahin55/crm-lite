package com.etiya.crmlite.services.responses.prod.prod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private Long prodId;

    // private List<Prod> childProdList;

    // private Prod parentProd;

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long trnscId;

    private Long cmpgId;

    private Long stId;

}
