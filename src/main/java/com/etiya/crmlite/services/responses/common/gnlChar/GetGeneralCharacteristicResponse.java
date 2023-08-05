package com.etiya.crmlite.services.responses.common.gnlChar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGeneralCharacteristicResponse {
    private Long charId;

    private String name;

    private String descr;

    private String prvdrCls;

    private String shrtCode;

    private int isActv;
}
