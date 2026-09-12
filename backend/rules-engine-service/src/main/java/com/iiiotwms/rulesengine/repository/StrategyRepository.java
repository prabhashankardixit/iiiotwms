package com.iiiotwms.rulesengine.repository;

import com.iiiotwms.rulesengine.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StrategyRepository extends JpaRepository<Strategy, Long> {
    List<Strategy> findByStrategyTypeAndStatus(String strategyType, String status);
}
