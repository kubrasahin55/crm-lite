package com.etiya.crmlite.services.responses.common.gnlSt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGeneralStatusResponse {
    private Long gnlStId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

    private String entCodeName;

    private String entName;
}
