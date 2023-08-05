package com.etiya.crmlite.entities.concretes.common;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.prod.ProdCharVal;
import com.etiya.crmlite.entities.concretes.prod.ProdSpecCharUse;
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
@Builder
@Table(name="GNL_CHAR")
public class GnlChar extends BaseEntity {
    @Id
    @SequenceGenerator(name = "gnlCharSeq", sequenceName = "GNL_CHAR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gnlCharSeq")
    @Column(name="CHAR_ID")
    private Long charId;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCR")
    private String descr;

    @Column(name="PRVDR_CLS")
    private String prvdrCls;

    @Column(name="SHRT_CODE")
    private String shrtCode;

    @Column(name="IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "gnlChar")
    private List<ProdCharVal> prodCharVals;

    @OneToMany(mappedBy = "gnlChar")
    private List<ProdSpecCharUse> prodSpecCharUses;

}
