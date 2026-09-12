package com.iiiotwms.inbound.repository;

import com.iiiotwms.inbound.entity.POHdr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PORepository extends JpaRepository<POHdr, Long> {
    Optional<POHdr> findByPoNumber(String poNumber);
}
