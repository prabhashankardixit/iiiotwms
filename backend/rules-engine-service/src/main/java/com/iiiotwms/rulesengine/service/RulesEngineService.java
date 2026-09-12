package com.iiiotwms.rulesengine.service;

import com.iiiotwms.rulesengine.entity.Rule;
import com.iiiotwms.rulesengine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class RulesEngineService {

    @Autowired private RuleRepository ruleRepo;

    public String decidePutaway(String lpn) {
        Rule rule = ruleRepo.findAll().stream()
                .sorted(Comparator.comparingInt(Rule::getPriority))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No rules configured"));
        return rule.getOutcome();
    }
}
