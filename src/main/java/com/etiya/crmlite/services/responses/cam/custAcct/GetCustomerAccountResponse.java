package com.etiya.crmlite.services.responses.cam.custAcct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCustomerAccountResponse {
    private Long customerAccountId;

    private String accountNumber;

    private String accountName;

    private String accountType;

    private String accountStatus;


}
