package com.iiiotwms.returns.repository;

import com.iiiotwms.returns.entity.ReturnHdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<ReturnHdr, Long> {
}
