package com.etiya.crmlite.services.responses.common.gnlSt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGeneralStatusResponse {

    private long generalStatusId;

    private String name;

    private String description;

    private String entCodeName;

    private String entName;

    private Integer isActive;

}
