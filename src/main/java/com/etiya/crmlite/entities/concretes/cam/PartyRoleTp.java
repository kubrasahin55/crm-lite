package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PARTY_ROLE_TP")
@Builder
public class PartyRoleTp extends BaseEntity {
    @Id
    @SequenceGenerator(name = "partyRoleTpSeq", sequenceName = "PARTY_ROLE_TP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyRoleTpSeq")
    @Column(name = "PARTY_ROLE_TP_ID")
    private Long partyRoleTpId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "partyRoleTp")
    private List<PartyRole> partyRoles;
}
