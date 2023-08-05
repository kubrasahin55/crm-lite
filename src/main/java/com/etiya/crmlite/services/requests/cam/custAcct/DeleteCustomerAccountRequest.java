package com.etiya.crmlite.services.requests.cam.custAcct;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCustomerAccountRequest {
    private Long customerAccountId;
}
