package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARTY")
@Builder
public class Party extends BaseEntity {
    @Id
    @SequenceGenerator(name = "partySeq", sequenceName = "PARTY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partySeq")
    @Column(name = "PARTY_ID")
    private Long partyId;

    @Column(name = "PARTY_TP_ID")
    private Long partyTpId;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "party")
    private List<PartyRole> partyRoles;

    @OneToOne(mappedBy = "party",cascade = CascadeType.ALL)
    private Ind ind;
}
