package com.etiya.crmlite.services.responses.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressResponse {
    private Long addrId;

    private Long rowId;

    private Long dataTpId;

    private Long strtId;

    private Long bldgId;

    private String addrDesc;

    private int isActv;

    private String cityName;

    private String strtName;

    private String bldgName;

    private String cntryName;
}
