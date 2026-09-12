package com.iiiotwms.outbound.repository;

import com.iiiotwms.outbound.entity.ShipmentHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<ShipmentHdr, Long> {
}
