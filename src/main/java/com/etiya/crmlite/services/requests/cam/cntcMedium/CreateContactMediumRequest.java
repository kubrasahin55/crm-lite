package com.etiya.crmlite.services.requests.cam.cntcMedium;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumRequest {
    private Long rowId;
    private Long dataTpId;
    private String cntcData;
    private Long stId;
    private Long cntcMediumTpId;
}
