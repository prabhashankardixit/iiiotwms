package com.iiiotwms.inbound.service;

import com.iiiotwms.inbound.entity.ASNHdr;
import com.iiiotwms.inbound.entity.POHdr;
import com.iiiotwms.inbound.entity.ReceiptHdr;
import com.iiiotwms.inbound.repository.ASNRepository;
import com.iiiotwms.inbound.repository.PORepository;
import com.iiiotwms.inbound.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundService {

    @Autowired private PORepository poRepo;
    @Autowired private ASNRepository asnRepo;
    @Autowired private ReceiptRepository receiptRepo;

    public POHdr createPO(POHdr po) { return poRepo.save(po); }
    public ASNHdr createASN(ASNHdr asn) { return asnRepo.save(asn); }
    public ReceiptHdr confirmReceipt(ReceiptHdr receipt) { return receiptRepo.save(receipt); }
}
