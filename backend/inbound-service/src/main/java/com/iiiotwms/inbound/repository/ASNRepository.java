package com.iiiotwms.inbound.repository;

import com.iiiotwms.inbound.entity.ASNHdr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ASNRepository extends JpaRepository<ASNHdr, Long> {
    Optional<ASNHdr> findByAsnNumber(String asnNumber);
    List<ASNHdr> findByPoHdrId(Long poHdrId);
}
