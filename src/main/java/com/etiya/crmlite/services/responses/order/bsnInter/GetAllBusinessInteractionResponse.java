package com.etiya.crmlite.services.responses.order.bsnInter;

import com.etiya.crmlite.entities.concretes.order.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBusinessInteractionResponse {

    private Long bsnInterId;

    private Long bsnInterSpecId;

    private Long custId;

    private String descr;

    private Long bsnInterStId;

    private Long prntBsnInterId;

    private Long rowId;

    private Long dataTpId;




}
