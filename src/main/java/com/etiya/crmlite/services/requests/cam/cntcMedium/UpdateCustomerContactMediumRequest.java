package com.etiya.crmlite.services.requests.cam.cntcMedium;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UpdateCustomerContactMediumRequest {
    private Long partyId;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @NotNull
    @Pattern(regexp="(^[0-9]{11}$)", message = " must consist of digits and 11 characters.")
    private String mobilePhone;
    private String homePhone;
    private String fax;

}
