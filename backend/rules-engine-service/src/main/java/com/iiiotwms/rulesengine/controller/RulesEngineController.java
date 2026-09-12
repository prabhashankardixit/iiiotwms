package com.iiiotwms.rulesengine.controller;

import com.iiiotwms.rulesengine.service.RulesEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rulesengine")
public class RulesEngineController {

    @Autowired private RulesEngineService service;

    @PostMapping("/putaway")
    public ResponseEntity<?> assignPutaway(@RequestBody Map<String, String> req) {
        String lpn = req.get("lpn");
        String location = service.decidePutaway(lpn);
        return ResponseEntity.ok(Map.of("lpn", lpn, "location", location));
    }
}
