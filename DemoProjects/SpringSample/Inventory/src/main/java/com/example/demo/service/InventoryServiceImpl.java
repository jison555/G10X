package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.model.InventoryModel;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.util.InventoryModelMapperUtil;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepo;

	@Autowired
	InventoryModelMapperUtil modelMapper;

	@Override
	public InventoryModel saveInventory(InventoryModel inventoryModel) {
		Inventory inv = modelMapper.convertInventoryModelToEntity(inventoryModel);
		inv = inventoryRepo.save(inv);
		return modelMapper.convertInventoryToModel(inv);
	}

	@Override
	public List<InventoryModel> getAllInventory() {
		List<Inventory> inventories = inventoryRepo.findAll();
		List<InventoryModel> inventoryModels = inventories.stream().map(modelMapper::convertInventoryToModel)
				.collect(Collectors.toList());
		return inventoryModels;
	}

}
