package com.iiiotwms.outbound.repository;

import com.iiiotwms.outbound.entity.SOHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SORepository extends JpaRepository<SOHdr, Long> {
}
