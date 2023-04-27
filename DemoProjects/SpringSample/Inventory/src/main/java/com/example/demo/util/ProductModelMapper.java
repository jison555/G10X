package com.example.demo.util;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Category;
import com.example.demo.entity.Location;
import com.example.demo.entity.Product;
import com.example.demo.model.CategoryModel;
import com.example.demo.model.InventoryModel;
import com.example.demo.model.LocationModel;
import com.example.demo.model.ProductModel;

@Component
public class ProductModelMapper {

	ModelMapper modelMapper;

	@PostConstruct
	private void createModelInstance() {
		modelMapper = new ModelMapper();
	}

	public Category convertCategoryModelToEntity(CategoryModel catModel) {
		return modelMapper.map(catModel, Category.class);
	}

	public Location convertLocationModelToEntity(LocationModel locModel) {
		return modelMapper.map(locModel, Location.class);
	}

	public CategoryModel convertCategoryToModel(Category cat) {
		return modelMapper.map(cat, CategoryModel.class);
	}

	public LocationModel convertLocationToModel(Location loc) {
		return modelMapper.map(loc, LocationModel.class);
	}

	public Product convertProductToEntity(ProductModel prodModel) {
		return modelMapper.map(prodModel, Product.class);
	}

	public ProductModel convertProductToModel(Product product) {

		// ProductModel prodModel = new ProductModel();

		ProductModel prodModel = modelMapper.map(product, ProductModel.class);
		prodModel.setCategoryModel(modelMapper.map(product.getCategory(), CategoryModel.class));
		prodModel.setInventoryModel(modelMapper.map(product.getInventory(), InventoryModel.class));
		return prodModel;
	}

}
