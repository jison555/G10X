package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.ProductModel;

public interface ProductService {
	
	public ProductModel saveProduct(ProductModel prod);
	public List<ProductModel> getAllProducts();
	public ProductModel getProductById(int id) throws NoDataFoundException;
	public int saveProductByLocId(Product prod,int locid);
	public List<ProductModel> updateQuantityOfProduct(List<ProductModel> listProd);
	public void deleteProduct(int id) throws NoDataFoundException;
	public ProductModel updateProduct(ProductModel prod,int id) throws NoDataFoundException;
	public List<Product> getProductDateFilter( Map<String, String> parms);


}
