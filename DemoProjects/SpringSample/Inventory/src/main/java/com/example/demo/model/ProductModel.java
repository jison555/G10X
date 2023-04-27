package com.example.demo.model;

import java.util.Date;

import com.example.demo.entity.Category;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Location;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductModel {
	private int prodId;
	private String name;
	private double price;
	private String discription;
	private int stockLevel;
	private Date manDate;
	private Date expDate;
	private LocationModel locationModel;
	private CategoryModel categoryModel;
	private SubCategoryModel subCategoryModel;
	private InventoryModel inventoryModel;
	private Date nextArrival;

	
		
}
