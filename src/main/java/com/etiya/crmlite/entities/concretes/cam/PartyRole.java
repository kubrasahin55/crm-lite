package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARTY_ROLE")
@Builder
public class PartyRole extends BaseEntity {
    @Id
    @SequenceGenerator(name = "partyRoleSeq", sequenceName = "PARTY_ROLE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyRoleSeq")
    @Column(name = "PARTY_ROLE_ID")
    private Long partyRoleId;

    @Column(name = "ST_ID")
    private Long stId;

    @ManyToOne
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @ManyToOne
    @JoinColumn(name = "PARTY_ROLE_TP_ID")
    private PartyRoleTp partyRoleTp;

    @OneToOne(mappedBy = "partyRole",cascade = CascadeType.ALL)
    private Cust cust;
}
