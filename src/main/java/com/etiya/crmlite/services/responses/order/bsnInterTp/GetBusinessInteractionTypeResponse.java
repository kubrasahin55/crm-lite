package com.etiya.crmlite.services.responses.order.bsnInterTp;

import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessInteractionTypeResponse {
    private Long bsnInterTpId;

    private Long prntBsnInterTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;
}
