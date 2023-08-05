package com.etiya.crmlite.services.requests.cam.addr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    private Long addressId;
    @NotNull
    private Long bldgId;
    @NotNull
    @NotBlank
    private String addrDesc;
    @NotNull
    @NotBlank
    private String cityName;
    @NotNull
    @NotBlank
    private String strtName;
    @NotNull
    @NotBlank
    private String cntryName;


}
