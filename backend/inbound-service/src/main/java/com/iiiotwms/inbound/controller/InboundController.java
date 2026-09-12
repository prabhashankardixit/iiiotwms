package com.iiiotwms.inbound.controller;

import com.iiiotwms.inbound.entity.ASNHdr;
import com.iiiotwms.inbound.entity.POHdr;
import com.iiiotwms.inbound.entity.ReceiptHdr;
import com.iiiotwms.inbound.service.InboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inbound")
public class InboundController {

    @Autowired private InboundService inboundService;

    @PostMapping("/po")
    public ResponseEntity<?> createPO(@RequestBody POHdr po) {
        return ResponseEntity.ok(inboundService.createPO(po));
    }

    @PostMapping("/asn")
    public ResponseEntity<?> createASN(@RequestBody ASNHdr asn) {
        return ResponseEntity.ok(inboundService.createASN(asn));
    }

    @PostMapping("/receipt")
    public ResponseEntity<?> confirmReceipt(@RequestBody ReceiptHdr receipt) {
        return ResponseEntity.ok(inboundService.confirmReceipt(receipt));
    }
}
