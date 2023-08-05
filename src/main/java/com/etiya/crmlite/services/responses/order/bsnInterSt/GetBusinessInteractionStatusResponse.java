package com.etiya.crmlite.services.responses.order.bsnInterSt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessInteractionStatusResponse {
    private Long bsnInterStId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

}
