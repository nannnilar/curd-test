package com.example.storecurd.dao;

import com.example.storecurd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository <Product, Integer>{
}
