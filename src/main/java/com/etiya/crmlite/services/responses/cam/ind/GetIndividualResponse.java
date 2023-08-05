package com.etiya.crmlite.services.responses.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetIndividualResponse {
    private Long indId;

    private String frstName;

    private String mName;

    private String lstName;

    private LocalDate brthDate;

    private int gendrId;

    private String mthrName;

    private String fthrName;

    private int natId;

    private Long stId;
}
