package com.etiya.crmlite.services.responses.common.gnlTp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllGeneralTypeResponse {

    private long generalTypeId;

    private String name;

    private String description;

    private String entCodeName;

    private String entName;

    private Integer isActive;
}
