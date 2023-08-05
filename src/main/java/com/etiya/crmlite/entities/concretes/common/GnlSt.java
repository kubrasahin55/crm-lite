package com.etiya.crmlite.entities.concretes.common;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "GNL_ST")
@Entity
public class GnlSt extends BaseEntity {
    @Id
    @SequenceGenerator(name = "gnlStSeq", sequenceName = "GNL_ST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gnlStSeq")
    @Column(name = "GNL_ST_ID")
    private Long gnlStId;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCR")
    private String descr;

    @Column(name="SHRT_CODE")
    private String shrtCode;

    @Column(name="IS_ACTV")
    private int isActv;

    @Column(name="ENT_CODE_NAME")
    private String entCodeName;

    @Column(name="ENT_NAME")
    private String entName;
}
