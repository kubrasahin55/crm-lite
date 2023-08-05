package com.etiya.crmlite.services.abstracts.cam;


import com.etiya.crmlite.entities.concretes.cam.Ind;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;

public interface IPartyService {
    Party createParty(Ind createInd, PartyRole createdPartyRole);
    Party save(Party party);
}
