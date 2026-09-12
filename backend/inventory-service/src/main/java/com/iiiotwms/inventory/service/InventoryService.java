package com.iiiotwms.inventory.service;

import com.iiiotwms.inventory.entity.InventoryHdr;
import com.iiiotwms.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired private InventoryRepository repo;

    public List<InventoryHdr> getAllInventory() {
        return repo.findAll();
    }

    public InventoryHdr addInventory(InventoryHdr inv) {
        return repo.save(inv);
    }
}
