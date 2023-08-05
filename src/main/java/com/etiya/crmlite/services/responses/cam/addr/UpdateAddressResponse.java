package com.etiya.crmlite.services.responses.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAddressResponse {
    private Long addressId;
    private Long bldgId;
    private String addrDesc;
    private String cityName;
    private String strtName;
    private String cntryName;
}
