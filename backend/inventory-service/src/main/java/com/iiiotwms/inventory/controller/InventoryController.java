package com.iiiotwms.inventory.controller;

import com.iiiotwms.inventory.entity.InventoryHdr;
import com.iiiotwms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired private InventoryService service;

    @GetMapping
    public ResponseEntity<?> getInventory() {
        return ResponseEntity.ok(service.getAllInventory());
    }

    @PostMapping
    public ResponseEntity<?> addInventory(@RequestBody InventoryHdr inv) {
        return ResponseEntity.ok(service.addInventory(inv));
    }
}
