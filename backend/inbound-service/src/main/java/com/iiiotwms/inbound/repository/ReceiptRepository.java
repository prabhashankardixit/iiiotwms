package com.iiiotwms.inbound.repository;

import com.iiiotwms.inbound.entity.ReceiptHdr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<ReceiptHdr, Long> {
    Optional<ReceiptHdr> findByReceiptNumber(String receiptNumber);
    List<ReceiptHdr> findByPoHdrId(Long poHdrId);
    List<ReceiptHdr> findByAsnHdrId(Long asnHdrId);
}
