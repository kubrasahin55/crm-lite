package com.etiya.crmlite.entities.concretes.prod;
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
@Table(name="PROD_OFR")
@Builder
public class ProdOfr extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodOfrSeq", sequenceName = "PROD_OFR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodOfrSeq")
    @Column(name = "PROD_OFR_ID")
    private Long prodOfrId;

    @ManyToOne
    @JoinColumn(name="PROD_SPEC_ID")
    private ProdSpec prodSpec;


    @Column(name="NAME")
    private String name;

    @Column(name="DESCR")
    private String descr;

    @OneToMany(mappedBy = "parentProdOfr")
    private List<ProdOfr> childProdOfrList;

    @ManyToOne
    @JoinColumn(name = "PRNT_OFR_ID")
    private ProdOfr parentProdOfr;

    @Column(name="ST_ID")
    private Long stId;

    @Column(name="PROD_OFR_TOTAL_PRC")
    private int prodOfrTotalPrcId;


    @OneToMany(mappedBy = "prodOfr")
    private List<CmpgProdOfr> cmpgProdOfrs;

    @OneToMany(mappedBy =  "prodOfr")
    private List<ProdCatalProdOfr> prodCatalProdOfrs;

    @OneToMany(mappedBy = "prodOfr")
    private List<Prod> prods;
}
