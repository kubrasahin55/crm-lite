package com.etiya.crmlite.services.responses.prod.prodCatalProdOfr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductCatalogProductOfferingResponse {
    private Long prodCatalProdOfrId;

    private Long prodCatalId;

    private Long prodOfrId;

    private Long stId;
}
