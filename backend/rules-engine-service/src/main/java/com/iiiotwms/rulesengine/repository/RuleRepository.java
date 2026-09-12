package com.iiiotwms.rulesengine.repository;

import com.iiiotwms.rulesengine.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}
