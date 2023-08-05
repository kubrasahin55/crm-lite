package com.etiya.crmlite.services.responses.prod.cmpg;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCampaignResponse {
    private Long cmpgId;

    private String name;

    private String descr;

    private String cmpgCode;

    private LocalDate actvtEdate;

    private Long stId;

    private int isPenalty;

    private Long cmpgProdOfrId;
}
