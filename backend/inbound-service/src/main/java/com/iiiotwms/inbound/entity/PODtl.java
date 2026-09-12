package com.iiiotwms.inbound.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "po_dtl")
public class PODtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "po_hdr_id", nullable = false)
    private POHdr poHdr;

    private String itemCode;
    private String itemDescription;
    private Integer orderedQty;
    private Integer receivedQty;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public POHdr getPoHdr() { return poHdr; }
    public void setPoHdr(POHdr poHdr) { this.poHdr = poHdr; }
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }
    public Integer getOrderedQty() { return orderedQty; }
    public void setOrderedQty(Integer orderedQty) { this.orderedQty = orderedQty; }
    public Integer getReceivedQty() { return receivedQty; }
    public void setReceivedQty(Integer receivedQty) { this.receivedQty = receivedQty; }
}
