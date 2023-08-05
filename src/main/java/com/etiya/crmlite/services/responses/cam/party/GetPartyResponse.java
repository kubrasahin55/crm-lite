package com.etiya.crmlite.services.responses.cam.party;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPartyResponse {
    private Long partyId;

    private Long partyTpId;

    private Long stId;

}
