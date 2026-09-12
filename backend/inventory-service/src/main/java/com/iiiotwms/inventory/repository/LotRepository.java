package com.iiiotwms.inventory.repository;

import com.iiiotwms.inventory.entity.LotHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<LotHdr, Long> {
}
