package com.etiya.crmlite.services.requests.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressWhenCreateCustomerRequest {
//    @NotNull
//    @NotBlank
    private String countryName;

    @NotNull
    @Size(max=100)
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String streetName;

//    @NotNull
//    @Size(max=100)
    private Long flatNumber;

    @NotNull
    @Size(max = 200)
    @NotBlank
    private String adressDescription;
}
