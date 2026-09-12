package com.iiiotwms.rulesengine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String condition;
    private String outcome;
    private int priority;

    @ManyToOne
    @JoinColumn(name = "strategy_id")
    private Strategy strategy;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public Strategy getStrategy() { return strategy; }
    public void setStrategy(Strategy strategy) { this.strategy = strategy; }
}
