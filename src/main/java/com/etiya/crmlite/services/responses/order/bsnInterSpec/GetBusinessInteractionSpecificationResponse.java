package com.etiya.crmlite.services.responses.order.bsnInterSpec;

import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessInteractionSpecificationResponse {
    private Long bsnInterSpecId;

    private Long bsnInterTpId;

    private Long childBsnInterSpecsId;

    private Long prntBsnInterSpecId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

    private Long bsnInterItemsId;

    private Long bsnIntersId;

}
