package com.tkith.shoppingsite.service;

import com.tkith.shoppingsite.entity.Product;

public interface ProductServiceInterface {
	
	public Iterable<Product> getAll();
	
	public Product getById(int id);
	
	public Product getByName(String name);
	
	public Product add(Product product);
	
	public void update(Product product);
	
	public void delete(int id);
}
