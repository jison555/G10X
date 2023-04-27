package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.URIConstants;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepo;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)
public class CategoryController {
	
	@Autowired
	CategoryRepo catRepo;
	
	@GetMapping("/category")
	public List<Category> getAllCategories() {
		List<Category> cats =  catRepo.findAll();
		List<Product> listProd = new ArrayList<>();
		for(Category cat:cats) {
			listProd.addAll(cat.getProducts().stream().collect(Collectors.toList()));
		}
		listProd.stream().forEach(x->System.out.println(x));
		return cats;
	}


}
