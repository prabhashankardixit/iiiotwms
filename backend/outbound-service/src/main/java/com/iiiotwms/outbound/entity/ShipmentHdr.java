package com.iiiotwms.outbound.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipment_hdr")
public class ShipmentHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentNumber;

    @ManyToOne
    @JoinColumn(name = "so_hdr_id")
    private SOHdr soHdr;

    private String carrier;
    private LocalDate shipDate;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getShipmentNumber() { return shipmentNumber; }
    public void setShipmentNumber(String shipmentNumber) { this.shipmentNumber = shipmentNumber; }
    public SOHdr getSoHdr() { return soHdr; }
    public void setSoHdr(SOHdr soHdr) { this.soHdr = soHdr; }
    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }
    public LocalDate getShipDate() { return shipDate; }
    public void setShipDate(LocalDate shipDate) { this.shipDate = shipDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
