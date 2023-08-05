package com.etiya.crmlite.services.requests.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressRequest {
    private Long customerId;


    private String addrDescription;

   private String cityName;

    private String streetName;

    private String buildingName;


}
