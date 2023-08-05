package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.cam.Cust;
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
@Table(name="CUST_TP")
public class CustTp extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custTpSeq", sequenceName = "CUST_TP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custTpSeq")
    @Column(name="CUST_TP_ID")
    private Long custTpId;

    @Column (name="NAME")
    private String name;

    @Column (name="DESCR")
    private String descr;

    @Column (name="SHRT_CODE")
    private String shrtCode;

    @Column (name="IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "custTp")
    private List<Cust> custs;

}
