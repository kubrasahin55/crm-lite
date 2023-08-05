package com.etiya.crmlite.services.responses.prod.prodOfr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductOfferingResponse {

    private Long prodOfrId;

    private Long prodSpecId;

    private String name;

    private String descr;

    private Long parentProdOfrId;

    private Long stId;

    private int prodOfrTotalPrcId;
}
