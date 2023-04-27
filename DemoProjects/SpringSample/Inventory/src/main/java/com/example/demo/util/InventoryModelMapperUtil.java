package com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import com.example.demo.model.InventoryModel;
import com.example.demo.model.ProductModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InventoryModelMapperUtil {

	ModelMapper modelMapper;

	@Autowired
	ProductModelMapper productMapper;

	@PostConstruct
	private void createModelInstance() {
		modelMapper = new ModelMapper();
	}

	public Inventory convertInventoryModelToEntity(InventoryModel inventoryModel) {
		List<ProductModel> prodModels = inventoryModel.getProduct();
		List<Product> prods = prodModels.stream().map(productMapper::convertProductToEntity)
				.collect(Collectors.toList());

		Inventory inv = modelMapper.map(inventoryModel, Inventory.class);
		inv.setProducts(prods);
		return inv;
	}

	public InventoryModel convertInventoryToModel(Inventory inventory) {
		return modelMapper.map(inventory, InventoryModel.class);
	}

}
