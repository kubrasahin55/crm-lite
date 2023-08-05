package com.etiya.crmlite.services.responses.common.etiyaTypeValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEtiyaTypeValueResponse {
    private Long typeValueId;

    private String tableName;

    private int fieldName;

    private String description;

    private String value;

    private String usingModuleName;
}
