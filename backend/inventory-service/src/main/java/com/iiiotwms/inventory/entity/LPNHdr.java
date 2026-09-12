package com.iiiotwms.inventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lpn_hdr")
public class LPNHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lpn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLpn() { return lpn; }
    public void setLpn(String lpn) { this.lpn = lpn; }
}
