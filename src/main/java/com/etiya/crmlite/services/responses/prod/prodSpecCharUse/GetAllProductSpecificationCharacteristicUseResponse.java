package com.etiya.crmlite.services.responses.prod.prodSpecCharUse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductSpecificationCharacteristicUseResponse {
    private Long prodSpecCharUseId;

    private Long prodSpecId;

    private Long gnlCharId;

    private String name;

    private int isActv;

    private String descr;
}
