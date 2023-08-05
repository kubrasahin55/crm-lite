package com.etiya.crmlite.services.responses.cam.cust;

import com.etiya.crmlite.services.requests.cam.cust.CreateAddressWhenCreateCustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerResponse {
    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private int gender;
    private String fatherName;
    private String motherName;
    private Long nationalityId;

    List<CreateAddressWhenCreateCustomerRequest> addressWhenCreateCustomerRequests;

    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
