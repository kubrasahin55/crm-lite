package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.CustomerTypes;
import com.etiya.crmlite.core.utilities.enums.PartyRoleTypes;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleService;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyRoleManager implements IPartyRoleService {
    private IPartyRoleTypeService partyRoleTypeService;

    @Autowired
    public PartyRoleManager(IPartyRoleTypeService partyRoleTypeService) {
        this.partyRoleTypeService = partyRoleTypeService;

    }


    @Override
    public PartyRole createPartyRole(Cust cust) {
        PartyRole createdPartyRole = PartyRole.builder()
                .stId(StatusCode.PARTY_ROLE_ACTV)
                .cust(cust)
                .partyRoleTp(partyRoleTypeService.getById(PartyRoleTypes.CUST2))
            .build();

        return createdPartyRole;
    }
}
