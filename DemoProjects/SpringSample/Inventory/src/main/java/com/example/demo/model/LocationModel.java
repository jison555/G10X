package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Product;

public class LocationModel {
	private int locId;
	private String locationName;
	private List<ProductModel> productsModel;
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public List<ProductModel> getProductsModel() {
		return productsModel;
	}
	public void setProductsModel(List<ProductModel> productsModel) {
		this.productsModel = productsModel;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	

	
	

}
