package com.inventoryService.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryService.app.model.Inventory;
import com.inventoryService.app.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateStock(@PathVariable Long productId, @RequestBody Integer quantity) {
        Inventory updatedInventory = inventoryService.updateStock(productId, quantity);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getStockByProductId(@PathVariable Long productId) {
        Optional<Inventory> inventory = inventoryService.getStockByProductId(productId);
        return new ResponseEntity<>(inventory.get(), HttpStatus.OK);
    }
}

