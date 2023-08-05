package com.etiya.crmlite.services.responses.common.gnlTp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGeneralTypeResponse {

    private Long gnlTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private String entCodeName;

    private String entName;

    private int isActv;
}
