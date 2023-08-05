package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.common.RsrcSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="PROD_SPEC_RSRC_SPEC")
public class ProdSpecRsrcSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodSpecRsrcSpecSeq", sequenceName = "PROD_SPEC_RSRC_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSpecRsrcSpecSeq")
    @Column (name="PROD_SPEC_RSRC_SPEC_ID")
    private Long prodSpecRsrcSpecId;

    @ManyToOne
    @JoinColumn(name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @ManyToOne
    @JoinColumn(name = "RSRC_SPEC_ID")
    private RsrcSpec rsrcSpec;

    @Column(name ="REL_TP_ID")
    private Long relTpId;

    @Column(name = "SDATE")
    private LocalDate sDate;

    @Column(name = "EDATE")
    private LocalDate eDate;

    @Column(name = "ST_ID")
    private int stId;
}
