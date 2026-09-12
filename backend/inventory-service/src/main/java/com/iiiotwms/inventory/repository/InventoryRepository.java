package com.iiiotwms.inventory.repository;

import com.iiiotwms.inventory.entity.InventoryHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryHdr, Long> {
}
