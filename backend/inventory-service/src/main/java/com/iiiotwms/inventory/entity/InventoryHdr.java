package com.iiiotwms.inventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_hdr")
public class InventoryHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemCode;
    private int quantity;
    private String location;

    @ManyToOne
    @JoinColumn(name = "lpn_id")
    private LPNHdr lpn;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private LotHdr lot;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LPNHdr getLpn() { return lpn; }
    public void setLpn(LPNHdr lpn) { this.lpn = lpn; }
    public LotHdr getLot() { return lot; }
    public void setLot(LotHdr lot) { this.lot = lot; }
}
