package com.etiya.crmlite.services.responses.prod.prodRel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductRelationResponse {

    private Long prodRelId;

    private Long prodId1;

    private Long prodId2;

    private Long relTpId;

    private int isActv;

}
