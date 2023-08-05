package com.etiya.crmlite.services.responses.prod.prodCatal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllProductCatalogResponse {
    private Long prodCatalId;

    private String name;

    private String descr;

    private Long stId;

    private String shrtCode;
}
