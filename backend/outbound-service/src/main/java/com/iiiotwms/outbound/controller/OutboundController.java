package com.iiiotwms.outbound.controller;

import com.iiiotwms.outbound.entity.SOHdr;
import com.iiiotwms.outbound.entity.ShipmentHdr;
import com.iiiotwms.outbound.service.OutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/outbound")
public class OutboundController {

    @Autowired private OutboundService service;

    @PostMapping("/so")
    public ResponseEntity<?> createSO(@RequestBody SOHdr so) {
        return ResponseEntity.ok(service.createSO(so));
    }

    @PostMapping("/shipment")
    public ResponseEntity<?> confirmShipment(@RequestBody ShipmentHdr ship) {
        return ResponseEntity.ok(service.confirmShipment(ship));
    }
}
