package com.iiiotwms.outbound.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "so_hdr")
public class SOHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String soNumber;
    private String customer;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSoNumber() { return soNumber; }
    public void setSoNumber(String soNumber) { this.soNumber = soNumber; }
    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
