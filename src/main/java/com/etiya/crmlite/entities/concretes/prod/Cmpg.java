package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CMPG")
@Builder
public class Cmpg extends BaseEntity {
    @Id
    @SequenceGenerator(name = "cmpgSeq", sequenceName = "CMPG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cmpgSeq")
    @Column(name = "CMPG_ID")
    private Long cmpgId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "CMPG_CODE")
    private String cmpgCode;

    @Column(name = "ACTVT_EDATE")
    private LocalDate actvtEdate;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "IS_PENALTY")
    private int isPenalty;

    @OneToMany(mappedBy = "cmpg")
    private List<CmpgProdOfr> cmpgProdOfrs;
}
