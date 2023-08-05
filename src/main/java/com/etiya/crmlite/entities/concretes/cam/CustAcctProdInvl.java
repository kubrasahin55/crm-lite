package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.prod.Prod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "CUST_ACCT_PROD_INVL")
public class CustAcctProdInvl extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custAcctProdInvlSeq", sequenceName = "CUST_ACCT_PROD_INVL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custAcctProdInvlSeq")
    @Column(name = "CUST_ACCT_PROD_INVL_ID")
    private Long custAcctProdInvlId;

    @ManyToOne
    @JoinColumn(name = "CUST_ACCT_ID")
    private CustAcct custAcct;

    @ManyToOne
    @JoinColumn(name = "PROD_ID")
    private Prod prod;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "ST_ID")
    private Long stId;

}
