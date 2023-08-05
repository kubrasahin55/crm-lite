package com.etiya.crmlite.services.responses.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAddressResponse {
    private Long addressId;
    private Long buildingId;
    private String addressDescription;
    private String cityName;
    private String streetName;
}

