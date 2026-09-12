package com.iiiotwms.inbound.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "receipt_hdr")
public class ReceiptHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiptNumber;

    @ManyToOne
    @JoinColumn(name = "asn_hdr_id")
    private ASNHdr asnHdr;

    @ManyToOne
    @JoinColumn(name = "po_hdr_id")
    private POHdr poHdr;

    private LocalDate receiptDate;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }
    public ASNHdr getAsnHdr() { return asnHdr; }
    public void setAsnHdr(ASNHdr asnHdr) { this.asnHdr = asnHdr; }
    public POHdr getPoHdr() { return poHdr; }
    public void setPoHdr(POHdr poHdr) { this.poHdr = poHdr; }
    public LocalDate getReceiptDate() { return receiptDate; }
    public void setReceiptDate(LocalDate receiptDate) { this.receiptDate = receiptDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
