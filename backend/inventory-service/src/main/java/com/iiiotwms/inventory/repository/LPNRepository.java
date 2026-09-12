package com.iiiotwms.inventory.repository;

import com.iiiotwms.inventory.entity.LPNHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LPNRepository extends JpaRepository<LPNHdr, Long> {
}
