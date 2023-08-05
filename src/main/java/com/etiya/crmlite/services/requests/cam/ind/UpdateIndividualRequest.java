package com.etiya.crmlite.services.requests.cam.ind;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualRequest {
    private long individualId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private int genderId;
    private String motherName;
    private String fatherName;
    private Long nationalityId;
}
