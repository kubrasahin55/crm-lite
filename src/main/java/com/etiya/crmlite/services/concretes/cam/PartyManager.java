package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.core.utilities.enums.GeneralTypes;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.repositories.cam.IPartyRepository;
import com.etiya.crmlite.services.abstracts.cam.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyManager implements IPartyService {
    private IPartyRepository partyRepository;

    @Autowired
    public PartyManager(IPartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Party createParty(Ind createInd, PartyRole createdPartyRole) {

        Party createParty = Party.builder()
                .stId(StatusCode.PARTY_ACTV)
                .partyTpId(GeneralTypes.INDV)
                .ind(createInd)
                .partyRoles(List.of(createdPartyRole))
                .build();

        return createParty;
    }

    @Override
    public Party save(Party party) {
        return partyRepository.save(party);
    }
}
