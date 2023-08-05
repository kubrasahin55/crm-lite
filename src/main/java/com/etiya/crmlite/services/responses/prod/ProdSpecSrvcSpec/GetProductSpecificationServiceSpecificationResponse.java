package com.etiya.crmlite.services.responses.prod.ProdSpecSrvcSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductSpecificationServiceSpecificationResponse {
    private Long prodSpecSrvcSpecId;

    private Long prodSpecId;

    private Long srvcSpecId;

    private Long relTpId;

    private LocalDate sDate;

    private LocalDate eDate;

    private int stId;
}
