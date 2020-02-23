package com.tkith.shoppingsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkith.shoppingsite.entity.Product;

@Repository
public interface ProductDAOInterface extends JpaRepository<Product, Integer> {
		
	Product findById(int id);
	
	Product findByName(String name);
}
