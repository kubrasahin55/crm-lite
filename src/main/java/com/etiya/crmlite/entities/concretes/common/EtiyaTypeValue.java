package com.etiya.crmlite.entities.concretes.common;

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
@Table(name = "ETIYA_TYPE_VALUE")
public class EtiyaTypeValue {
    @Id
    @SequenceGenerator(name = "etiyaTypeValueSeq", sequenceName = "TYPE_VALUE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "etiyaTypeValueSeq")
    @Column(name = "TYPE_VALUE_ID")
    private Long typeValueId;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "FIELD_NAME")
    private int fieldName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "USING_MODULE_NAME")
    private String usingModuleName;

}
