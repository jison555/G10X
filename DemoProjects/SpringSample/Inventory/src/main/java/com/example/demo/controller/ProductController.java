package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.client.MyfeignClient;
import com.example.demo.constants.URIConstants;
import com.example.demo.entity.Product;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/product")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductModel prodModel) {
		prodModel = productService.saveProduct(prodModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(prodModel);
	}

	@GetMapping(path = "/product")
	public ResponseEntity<List<ProductModel>> allProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}

	@GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductModel> getProductById(@PathVariable int id) throws NoDataFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
	}

	@PutMapping(path = "/product/{id}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable int id, @RequestBody ProductModel prod)
			throws NoDataFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(prod, id));
	}

	@DeleteMapping(path = "/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) throws NoDataFoundException {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body("product with id =" + id + " deleted successfully");
	}

	@PutMapping(path = "/products/qty")
	// pass product and id and quantity to reduce from table
	public List<ProductModel> updateQuantityProduct(@RequestBody List<ProductModel> prodList) {
		return productService.updateQuantityOfProduct(prodList);
	}

	@PostMapping(path = "/product/{locId}")
	public ResponseEntity<Integer> saveProductByLocId(@RequestBody Product prod, @PathVariable int locId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProductByLocId(prod, locId));
	}

	// filtering using jdbcTemplate
	@GetMapping("/getProdOndate")
	public List<Product> getProductBasedOnDate(@RequestParam Map<String, String> parms) {

		return productService.getProductDateFilter(parms);
	}

}
