package com.etiya.crmlite.services.requests.cam.addr;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountAddressRequest {
    @NotNull
    @NotBlank
    private String addrDescripton;
    @NotNull
    @NotBlank
    private String cityName;
    @NotNull
    @NotBlank
    private String streetName;
    @NotNull
    @NotBlank
    private String buildingName;

}
