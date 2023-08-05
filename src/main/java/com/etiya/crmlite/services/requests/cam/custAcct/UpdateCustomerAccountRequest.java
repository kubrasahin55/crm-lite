package com.etiya.crmlite.services.requests.cam.custAcct;

import com.etiya.crmlite.services.requests.cam.addr.CreateAccountAddressRequest;
import com.etiya.crmlite.services.requests.cam.addr.UpdateAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerAccountRequest {
    private Long customerAccountId;

    @Size(max=100)
    @NotNull
    @NotBlank
    private String accountName;

    @Size(max=100)
    @NotNull
    @NotBlank
    private String description;

    @Valid
    private UpdateAddressRequest updateAddressRequest;
}
