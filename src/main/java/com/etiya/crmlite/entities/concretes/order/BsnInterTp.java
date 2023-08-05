package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "BSN_INTER_TP")
public class BsnInterTp extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterTpSeq", sequenceName = "BSN_INTER_TP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterTpSeq")
    @Column(name = "BSN_INTER_TP_ID")
    private Long bsnInterTpId;

    @OneToMany(mappedBy = "prntBsnInterTp")
    private List<BsnInterTp> childBsnInterTps;

    @ManyToOne
    @JoinColumn(name = "PRNT_BSN_INTER_TP_ID")
    private BsnInterTp prntBsnInterTp;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "bsnInterTp")
    private List<BsnInterSpec> bsnInterSpecs;


}

