package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CMPG_PROD_OFR")
@Builder
public class CmpgProdOfr extends BaseEntity {
    @Id
    @SequenceGenerator(name = "cmpgProdOfrSeq", sequenceName = "CMPG_PROD_OFR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cmpgProdOfrSeq")
    @Column(name = "CMPG_PROD_OFR_ID")
    private Long cmpgProdOfrId;

    @ManyToOne
    @JoinColumn(name = "CMPG_ID")
    private Cmpg cmpg;

    @ManyToOne
    @JoinColumn(name = "PROD_OFR_ID")
    private ProdOfr prodOfr;

    @Column(name = "PROD_OFR_NAME")
    private String prodOfrName;

    @Column(name = "PRIO")
    private int prio;

    @Column(name = "SDATE")
    private LocalDate sDate;

    @Column(name = "EDATE")
    private LocalDate eDate;

    @Column(name = "IS_ACTV")
    private int isActv;
}
