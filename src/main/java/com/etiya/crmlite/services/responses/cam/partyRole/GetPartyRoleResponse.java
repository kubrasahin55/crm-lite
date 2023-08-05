package com.etiya.crmlite.services.responses.cam.partyRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPartyRoleResponse {
    private Long partyRoleId;

    private Long stId;

    private Long partyId;

    private Long partyRoleTpId;

}
