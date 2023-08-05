package com.etiya.crmlite.services.requests.cam.custAcct;

import com.etiya.crmlite.services.requests.cam.addr.CreateAccountAddressRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerAccountRequest {
    @NotNull
    private Long customerId;

    @Size(max=100)
    @NotNull
    @NotBlank
    private String accountName;

    @Size(max=100)
    @NotNull
    @NotBlank
    private String description;

    @Valid
    private CreateAccountAddressRequest addressRequest;
}
