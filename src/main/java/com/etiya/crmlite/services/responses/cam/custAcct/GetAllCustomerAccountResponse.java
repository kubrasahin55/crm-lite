package com.etiya.crmlite.services.responses.cam.custAcct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerAccountResponse {
    private Long customerAccountId;

    private String accountNumber;

    private String accountName;

    private String accountType;

    private String accountStatus;

}
