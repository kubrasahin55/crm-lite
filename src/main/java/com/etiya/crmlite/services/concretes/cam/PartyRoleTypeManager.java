package com.etiya.crmlite.services.concretes.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import com.etiya.crmlite.repositories.cam.IPartyRoleTypeRepository;
import com.etiya.crmlite.services.abstracts.cam.IPartyRoleTypeService;
import org.springframework.stereotype.Service;

@Service
public class PartyRoleTypeManager implements IPartyRoleTypeService {
        private IPartyRoleTypeRepository partyRoleTypeRepository;

    public PartyRoleTypeManager(IPartyRoleTypeRepository partyRoleTypeRepository) {
        this.partyRoleTypeRepository = partyRoleTypeRepository;
    }

    @Override
    public PartyRoleTp getById(Long partyRoleTpId) {
        return this.partyRoleTypeRepository.findById(partyRoleTpId).orElseThrow();
    }
}
