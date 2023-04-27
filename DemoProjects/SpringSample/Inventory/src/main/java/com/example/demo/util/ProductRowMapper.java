package com.example.demo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product prod = new Product();
		prod.setProdId(rs.getInt("product_id"));
		prod.setName(rs.getString("prod_name"));
		prod.setPrice(rs.getDouble("price_per_unit"));
		prod.setStockLevel(rs.getInt("stock_level"));
		prod.setManDate(rs.getDate("manufacture_date"));
		prod.setExpDate(rs.getDate("expire_date"));
		//prod.setCategory(rs.getObject("category_id"));

		return prod;

	}

}
