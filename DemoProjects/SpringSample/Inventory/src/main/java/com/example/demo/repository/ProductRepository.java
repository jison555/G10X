package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query("INSERT INTO product(name,catagory_id)" + "VALUES (prod.name, id );")
//	int insertDataByprodId(Product prod, int id);

}
