package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="PROD_SPEC")
public class ProdSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSpecSeq", sequenceName = "PROD_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSpecSeq")
    @Column (name="PROD_SPEC_ID")
    private Long prodSpecId;

    @Column (name="NAME")
    private String name;

    @Column (name="DESCR")
    private String descr;

    @OneToMany (mappedBy = "prodSpec")
    private List<ProdOfr> prodOfrs;

    @Column (name="IS_DEV")
    private int isDev;

    @OneToMany (mappedBy = "prodSpec")
    private List<Prod> prods;

    @OneToMany(mappedBy = "prodSpec")
    private List<ProdSpecRsrcSpec> prodSpecRsrcSpecs;

    @OneToMany(mappedBy = "prodSpec")
    private List<ProdSpecSrvcSpec> prodSpecSrvcSpecs;

    @OneToMany(mappedBy = "prodSpec")
    private List<ProdSpecCharUse> prodSpecCharUses;
}
