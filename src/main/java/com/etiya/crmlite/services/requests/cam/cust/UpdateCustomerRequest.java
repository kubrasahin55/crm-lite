package com.etiya.crmlite.services.requests.cam.cust;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private Long custId;

    //individual
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String middleName;

    @Size(max = 100)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    private int gender;

    @Size(max = 100)
    private String fatherName;

    @Size(max = 100)
    private String motherName;

    private String nationalityId;

}
