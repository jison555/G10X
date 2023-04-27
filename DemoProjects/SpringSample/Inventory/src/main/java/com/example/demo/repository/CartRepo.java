package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
