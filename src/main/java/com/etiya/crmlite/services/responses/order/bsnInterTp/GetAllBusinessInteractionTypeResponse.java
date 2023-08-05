package com.etiya.crmlite.services.responses.order.bsnInterTp;

import com.etiya.crmlite.entities.concretes.order.BsnInterSpec;
import com.etiya.crmlite.entities.concretes.order.BsnInterTp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBusinessInteractionTypeResponse {
    private Long bsnInterTpId;

    private Long prntBsnInterTpId;

    private String name;

    private String descr;

    private String shrtCode;

    private int isActv;

}
