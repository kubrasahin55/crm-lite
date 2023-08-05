package com.etiya.crmlite.services.responses.order.bsnInter;

import com.etiya.crmlite.entities.concretes.order.BsnInter;
import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import com.etiya.crmlite.entities.concretes.order.BsnInterSt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessInteractionResponse {

    private Long bsnInterId;

    private Long bsnInterSpecId;

    private Long custId;

    private String descr;

    private Long bsnInterStId;

    private Long prntBsnInterId;

    private Long rowId;

    private Long dataTpId;


}
