package com.etiya.crmlite.services.responses.cam.custAcct;

import com.etiya.crmlite.services.requests.cam.addr.CreateAccountAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerAccountResponse {
    private Long customerId;
    private String accountName;
    private String description;
    private CreateAccountAddressRequest addressRequest;
}
