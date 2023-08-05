package com.etiya.crmlite.services.responses.cam.partyRoleTp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPartyRoleTypeResponse {
    private Long partyRoleTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

}
