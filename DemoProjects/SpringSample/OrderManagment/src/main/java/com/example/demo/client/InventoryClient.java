package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Products;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

	@PutMapping(path = "/core/v1/products/qty")
	// pass product and id and quantity to reduce from table
	public List<Products> updateQuantityProduct(@RequestBody List<ProductModel> prodList);

	@GetMapping(path = "/core/v1/user")
	public ResponseEntity<UserModel> getUser(@RequestParam Long mob);

}
