package com.etiya.crmlite.services.responses.cam.custAcct;

import com.etiya.crmlite.services.requests.cam.addr.UpdateAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerAccountResponse {
    private Long customerAccountId;
    private String accountName;
    private String description;
    private UpdateAddressRequest updateAddressRequest;
}
