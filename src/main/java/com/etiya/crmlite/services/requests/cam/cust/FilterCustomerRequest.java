package com.etiya.crmlite.services.requests.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCustomerRequest {
    private Long nationalityId;
    private Long customerId;
    private String accountNumber;
    private String gsmNumber;
    private String firstName;
    private String lastName;
    private Long orderId;
}
