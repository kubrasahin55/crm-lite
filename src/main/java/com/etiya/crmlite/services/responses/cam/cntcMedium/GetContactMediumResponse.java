package com.etiya.crmlite.services.responses.cam.cntcMedium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetContactMediumResponse {
    private Long cntcMediumId;

    private Long rowId;

    private Long dataTpId;

    private String cntcData;

    private Long stId;

    private Long cntcMediumTpId;
}
