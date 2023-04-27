package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Product;

public class CategoryModel {
	private int categoryId;
	private String categoryName;
	private List<ProductModel> productsModel;
	private List<SubCategoryModel> subCategoriesModel;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<ProductModel> getProductsModel() {
		return productsModel;
	}
	public void setProductsModel(List<ProductModel> productsModel) {
		this.productsModel = productsModel;
	}
	public List<SubCategoryModel> getSubCategoriesModel() {
		return subCategoriesModel;
	}
	public void setSubCategoriesModel(List<SubCategoryModel> subCategoriesModel) {
		this.subCategoriesModel = subCategoriesModel;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	

		
	

}
