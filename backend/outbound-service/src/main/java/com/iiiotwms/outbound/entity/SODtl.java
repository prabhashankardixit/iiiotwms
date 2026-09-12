package com.iiiotwms.outbound.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "so_dtl")
public class SODtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "so_hdr_id", nullable = false)
    private SOHdr soHdr;

    private String itemCode;
    private Integer orderedQty;
    private Integer shippedQty;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SOHdr getSoHdr() { return soHdr; }
    public void setSoHdr(SOHdr soHdr) { this.soHdr = soHdr; }
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public Integer getOrderedQty() { return orderedQty; }
    public void setOrderedQty(Integer orderedQty) { this.orderedQty = orderedQty; }
    public Integer getShippedQty() { return shippedQty; }
    public void setShippedQty(Integer shippedQty) { this.shippedQty = shippedQty; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
