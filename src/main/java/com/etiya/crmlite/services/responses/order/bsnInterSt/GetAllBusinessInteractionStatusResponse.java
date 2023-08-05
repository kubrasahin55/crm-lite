package com.etiya.crmlite.services.responses.order.bsnInterSt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBusinessInteractionStatusResponse {

    private Long bsnInterStId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

}
