package com.etiya.crmlite.services.requests.cam.cust;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCustomerRequest {
    private Long customerId;
}
