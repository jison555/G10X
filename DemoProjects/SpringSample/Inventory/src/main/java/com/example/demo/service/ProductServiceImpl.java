package com.example.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepository;
import com.example.demo.util.ProductModelMapper;
import com.example.demo.util.ProductRowMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	CategoryRepo catRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ProductModelMapper modelMapperUtil;

	@Override
	public List<ProductModel> getAllProducts() {
		List<Product> allProducts = productRepo.findAll();
		return allProducts.stream().map(modelMapperUtil::convertProductToModel).collect(Collectors.toList());
	}

	@Override
	public ProductModel saveProduct(ProductModel prodModel) {
		Product product = modelMapperUtil.convertProductToEntity(prodModel);
		int id = product.getCategory().getCategoryId();
		Optional<Category> optCat = catRepo.findById(id);
		if (optCat.isPresent()) {
			product.setCategory(optCat.get());
		}
		product = productRepo.save(product);
		return modelMapperUtil.convertProductToModel(product);
	}

	@Override
	public ProductModel getProductById(int id) throws NoDataFoundException {
		Optional<Product> prod = productRepo.findById(id);
		if (prod.isPresent()) {
			return modelMapperUtil.convertProductToModel(prod.get());
		} else {
			throw new NoDataFoundException();
		}
	}

	@Override
	public List<ProductModel> updateQuantityOfProduct(List<ProductModel> listProdModel) {
		// TODO Auto-generated method stub
		List<Product> products = listProdModel.stream().map(modelMapperUtil::convertProductToEntity)
				.collect(Collectors.toList());
		List<ProductModel> updatedProducts = new ArrayList<>();

		List<Product> productsData = products.stream().map(prod -> prod.getProdId()).map(productRepo::findById)
				.filter(x -> x.isPresent()).map(x -> x.get()).collect(Collectors.toList());

		for (Product prod : products) {
			for (Product prodDB : productsData) {
				if (prod.getProdId() == prodDB.getProdId() && (prodDB.getStockLevel() >= prod.getStockLevel())) {
					prodDB.setStockLevel((prodDB.getStockLevel() - prod.getStockLevel()));
					Product product = productRepo.save(prodDB);
					// product.setStockLevel(prod.getStockLevel());
					updatedProducts.add(modelMapperUtil.convertProductToModel(product));
					break;
				}
			}
		}

		return updatedProducts;

	}

	@Override
	public int saveProductByLocId(Product prod, int locid) {
		// return productRepo.insertDataByprodId(prod,locid);
		return 1;
	}

	@Override
	public ProductModel updateProduct(ProductModel prodModel, int id) throws NoDataFoundException {

		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = modelMapperUtil.convertProductToEntity(prodModel);
			product.setProdId(optionalProduct.get().getProdId());
			product = productRepo.save(product);
			return modelMapperUtil.convertProductToModel(product);
		} else {
			throw new NoDataFoundException();
		}
	}

	@Override
	public void deleteProduct(int id) throws NoDataFoundException {
		try {
			productRepo.deleteById(id);
		} catch (Exception e) {
			throw new NoDataFoundException();
		}
	}

	@Override
	public List<Product> getProductDateFilter(Map<String, String> parms) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select * from Product where");
		Set<String> keySet = parms.keySet();
		ArrayList<Object> obj = new ArrayList<>();
		int count = 0;

		Iterator<Entry<String, String>> itr = parms.entrySet().iterator();

		while (itr.hasNext()) {

			Entry<String, String> entry = itr.next();
			obj.add(entry.getValue());
			String key = entry.getKey();
			if (count != 0) {
				sql.append(" and ");
			}
			count++;
			switch (key) {
			case "manDate":
				sql.append(" manufacture_date>=?");
				break;
			case "expDate":
				sql.append(" expire_date<=?");
				break;
			case "name":
				sql.append(" prod_name=?");
				break;
			case "fromprice":
				sql.append(" price_per_unit>=?");
				break;
			case "toprice":
				sql.append(" price_per_unit<=?");
				break;
			}
		}
		return jdbcTemplate.query(sql.toString(), obj.toArray(), new ProductRowMapper());
	}

}
