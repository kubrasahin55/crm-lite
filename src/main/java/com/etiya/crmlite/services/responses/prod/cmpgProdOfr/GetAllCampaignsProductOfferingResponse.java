package com.etiya.crmlite.services.responses.prod.cmpgProdOfr;
import com.etiya.crmlite.entities.concretes.prod.Cmpg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCampaignsProductOfferingResponse {
    private Long cmpgProdOfrId;

    private Cmpg cmpgId;

    private Long prodOfrId;

    private String prodOfrName;

    private int prio;

    private LocalDate sDate;

    private LocalDate eDate;

    private int isActv;
}
