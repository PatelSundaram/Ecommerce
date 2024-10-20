package com.inventoryService.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryService.app.model.Inventory;
import com.inventoryService.app.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public Inventory updateStock(Long productId, Integer quantity) {
		Optional<Inventory> inventory = inventoryRepository.findById(productId);

		inventory.get().setStockQuantity(quantity);
		return inventoryRepository.save(inventory.get());
	}

	public Optional<Inventory> getStockByProductId(Long productId) {
		return inventoryRepository.findById(productId);

	}

	// Additional methods for updating inventory levels
}
