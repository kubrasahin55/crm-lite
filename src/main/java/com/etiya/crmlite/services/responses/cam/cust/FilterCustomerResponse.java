package com.etiya.crmlite.services.responses.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterCustomerResponse {
    private Long nationalityId;
    private Long customerId;
    private String firstName;
    private String secondName;
    private String lastName;
    private String roleName;
}
