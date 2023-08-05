package com.etiya.crmlite.services.responses.prod.ProdSpecRsrcSpec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductSpecificationResourceSpecificationResponse {
    private Long prodSpecRsrcSpecId;

    private Long prodSpecId;

    private Long rsrcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private int stId;
}
