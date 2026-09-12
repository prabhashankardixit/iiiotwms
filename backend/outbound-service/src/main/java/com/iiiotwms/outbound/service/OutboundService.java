package com.iiiotwms.outbound.service;

import com.iiiotwms.outbound.entity.SOHdr;
import com.iiiotwms.outbound.entity.ShipmentHdr;
import com.iiiotwms.outbound.repository.SORepository;
import com.iiiotwms.outbound.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutboundService {

    @Autowired private SORepository soRepo;
    @Autowired private ShipmentRepository shipRepo;

    public SOHdr createSO(SOHdr so) { return soRepo.save(so); }
    public ShipmentHdr confirmShipment(ShipmentHdr ship) { return shipRepo.save(ship); }
}
