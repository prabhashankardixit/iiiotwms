package com.iiiotwms.rulesengine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "strategy")
public class Strategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String strategyName;
    private String strategyType;   // e.g. PUTAWAY, PICKING
    private String method;         // e.g. FIFO, LIFO, FEFO, FIXED_LOCATION
    private String zone;           // warehouse zone this strategy applies to
    private String status;         // ACTIVE, INACTIVE

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStrategyName() { return strategyName; }
    public void setStrategyName(String strategyName) { this.strategyName = strategyName; }
    public String getStrategyType() { return strategyType; }
    public void setStrategyType(String strategyType) { this.strategyType = strategyType; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
