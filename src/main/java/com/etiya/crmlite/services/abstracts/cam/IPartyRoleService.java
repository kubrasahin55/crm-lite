package com.etiya.crmlite.services.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;

import java.util.List;

public interface IPartyRoleService {
    PartyRole createPartyRole(Cust cust);
}
