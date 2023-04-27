package com.example.demo.service;

import java.util.List;

import com.example.demo.model.InventoryModel;

public interface InventoryService {
	
	public InventoryModel saveInventory(InventoryModel inventoryModel);
	public List<InventoryModel> getAllInventory();

}
