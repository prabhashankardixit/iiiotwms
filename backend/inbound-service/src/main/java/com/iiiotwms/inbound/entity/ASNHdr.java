package com.iiiotwms.inbound.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asn_hdr")
public class ASNHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asnNumber;

    @ManyToOne
    @JoinColumn(name = "po_hdr_id")
    private POHdr poHdr;

    private String supplier;
    private LocalDate expectedDate;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAsnNumber() { return asnNumber; }
    public void setAsnNumber(String asnNumber) { this.asnNumber = asnNumber; }
    public POHdr getPoHdr() { return poHdr; }
    public void setPoHdr(POHdr poHdr) { this.poHdr = poHdr; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public LocalDate getExpectedDate() { return expectedDate; }
    public void setExpectedDate(LocalDate expectedDate) { this.expectedDate = expectedDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
