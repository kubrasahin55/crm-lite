package com.etiya.crmlite.services.responses.prod.prodCharVal;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductCharacteristicValueResponse {
    private String generalCharacterName;
    private String value;
}
