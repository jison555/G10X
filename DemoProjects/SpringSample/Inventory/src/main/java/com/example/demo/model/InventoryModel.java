package com.example.demo.model;

import java.util.List;

import lombok.Data;
@Data
public class InventoryModel {
	
	private String invName;
	
	private List<ProductModel> product;

	private List<CategoryModel> categoriesModel;
	
	private List<SubCategoryModel> subCategoriesModel;

	private List<LocationModel> locations;

}
