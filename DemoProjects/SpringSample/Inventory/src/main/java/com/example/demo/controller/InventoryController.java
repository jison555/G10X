package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.URIConstants;
import com.example.demo.model.InventoryModel;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)

public class InventoryController {
	
	@Autowired
	InventoryService invService;
	
	@PostMapping("/inventory")
	public ResponseEntity<InventoryModel> saveInventory(@RequestBody InventoryModel inventoryModel){
		inventoryModel =  invService.saveInventory(inventoryModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(inventoryModel);
		
	}
	
	@GetMapping("/inventory")
	public ResponseEntity<List<InventoryModel>> getInventory(){
		List<InventoryModel> invModels  =  invService.getAllInventory();
		return ResponseEntity.status(HttpStatus.CREATED).body(invModels);
		
	}

}
