package com.etiya.crmlite.entities.concretes.prod;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.common.GnlChar;
import com.etiya.crmlite.entities.concretes.common.GnlCharVal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_CHAR_VAL")
@Entity
@Builder
public class ProdCharVal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "prodCharValSeq", sequenceName = "PROD_CHAR_VAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodCharValSeq")
    @Column(name = "PROD_CHAR_VAL_ID")
    private Long prodCharValId;

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private Prod prod;

    @ManyToOne
    @JoinColumn(name = "CHAR_ID")
    private GnlChar gnlChar;

    @ManyToOne
    @JoinColumn(name = "CHAR_VAL_ID")
    private GnlCharVal gnlCharVal;

    @Column(name = "VAL")
    private String val;

    @Column(name = "ST_ID")
    private Long stId;
}
