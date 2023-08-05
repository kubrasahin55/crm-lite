package com.etiya.crmlite.services.responses.order.bsnInterItem;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessInteractionItemResponse {

    private Long bsnInterItemId;

    private Long bsnInterId;

    private Long bsnInterSpecId;

    private String descr;

    private Long rowId;

    private Long dataTpId;

    private Long actnTpId;

    private Long stId;
}
