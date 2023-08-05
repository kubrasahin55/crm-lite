package com.etiya.crmlite.services.responses.prod.prodCharVal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductCharacteristicValueResponse {
    private Long prodCharValId;

    private Long prodId;

    private Long gnlCharId;

    private Long gnlCharValId;

    private String val;

    private Long stId;
}
