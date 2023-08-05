package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.cam.CustAcctProdInvl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROD")
@Builder
public class Prod extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSeq", sequenceName = "PROD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSeq")
    @Column(name = "PROD_ID")
    private Long prodId;

    @OneToMany(mappedBy = "parentProd")
    private List<Prod> childProdList;

    @ManyToOne
    @JoinColumn(name = "PRNT_PROD_ID")
    private Prod parentProd;

    @ManyToOne
    @JoinColumn(name = "PROD_OFR_ID")
    private ProdOfr prodOfr;

    @ManyToOne
    @JoinColumn(name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "TRNSC_ID")
    private Long trnscId;

    @Column(name = "CMPG_ID")
    private Long cmpgId;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "prod1")
    private List<ProdRel> prodRels1;

    @OneToMany(mappedBy = "prod2")
    private List<ProdRel> prodRels2;

    @OneToMany(mappedBy = "prod")
    private List<CustAcctProdInvl> custAcctProdInvls;

    @OneToMany(mappedBy = "prod")
    private List<ProdCharVal> prodCharVals;

}
