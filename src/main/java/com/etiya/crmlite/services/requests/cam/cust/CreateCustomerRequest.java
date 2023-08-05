package com.etiya.crmlite.services.requests.cam.cust;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String middleName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    private int gender;

    @Size(max = 100)
    private String fatherName;

    @Size(max = 100)
    private String motherName;

    @Pattern(regexp="(^[0-9]{11}$)", message = "Nationality id must consist of digits and 11 characters.")
    private String nationalityId;

//    @Valid
    List<CreateAddressWhenCreateCustomerRequest> addressWhenCreateCustomerRequests;

    @Email
    @NotNull
    @Size(max = 100)
    private String email;
    @Pattern(regexp="(^[0-9]{11}$)", message = "Home number must consist of digits and 11 characters.")
    private String homePhone;
    @NotNull
    @Pattern(regexp="(^[0-9]{11}$)", message = "Phone number must consist of digits and 11 characters.")
    private String mobilePhone;
    @Pattern(regexp="(^[0-9]{11}$)", message = "Fax must consist of digits and 11 characters.")
    private String fax;
}
