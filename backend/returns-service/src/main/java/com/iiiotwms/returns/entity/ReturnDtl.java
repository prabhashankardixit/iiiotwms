package com.iiiotwms.returns.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "return_dtl")
public class ReturnDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "return_hdr_id", nullable = false)
    private ReturnHdr returnHdr;

    private String itemCode;
    private Integer returnedQty;
    private String condition;   // GOOD, DAMAGED, EXPIRED
    private String disposition; // RESTOCK, SCRAP, QUARANTINE

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ReturnHdr getReturnHdr() { return returnHdr; }
    public void setReturnHdr(ReturnHdr returnHdr) { this.returnHdr = returnHdr; }
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public Integer getReturnedQty() { return returnedQty; }
    public void setReturnedQty(Integer returnedQty) { this.returnedQty = returnedQty; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public String getDisposition() { return disposition; }
    public void setDisposition(String disposition) { this.disposition = disposition; }
}
