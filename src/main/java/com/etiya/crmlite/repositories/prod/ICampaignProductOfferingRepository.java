package com.etiya.crmlite.repositories.prod;

import com.etiya.crmlite.entities.concretes.prod.CmpgProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICampaignProductOfferingRepository extends JpaRepository<CmpgProdOfr,Long> {
}
