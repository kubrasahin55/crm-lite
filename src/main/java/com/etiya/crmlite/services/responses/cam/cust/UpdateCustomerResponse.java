package com.etiya.crmlite.services.responses.cam.cust;

 
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerResponse {
    private Long custId;
    //individual
    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    private int gender;

    private String fatherName;

    private String motherName;

    private Long nationalityId;
}
