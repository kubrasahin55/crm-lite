package com.etiya.crmlite.entities.concretes.cam;
import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "CUST_ACCT")
public class CustAcct extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custAcctSeq", sequenceName = "CUST_ACCT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custAcctSeq")
    @Column(name = "CUST_ACCT_ID")
    private Long custAcctId;

    @Column(name = "ACCT_NO")
    private String acctNo;

    @Column(name = "ACCT_NAME")
    private String acctName;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "ACCT_TP_ID")
    private Long acctTpId;

    @Column(name = "DESCR")
    private String descr;
    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Cust cust;

    @OneToMany(mappedBy = "custAcct")
    private List<CustAcctProdInvl> custAcctProdInvls;
}
