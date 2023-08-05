package com.etiya.crmlite.services.responses.common.gnlCharVal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGeneralCharacteristicValueResponse {

    private Long charValId;

    private int charId;

    private int isDflt;

    private String val;

    private String shrtCode;

    private LocalDate sDate;

    private LocalDate eDate;

    private int isActv;
}
