package com.tkith.shoppingsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkith.shoppingsite.dao.ProductDAOInterface;
import com.tkith.shoppingsite.entity.Product;

@Service
public class ProductService implements ProductServiceInterface {
	
	private ProductDAOInterface productDAO;

	@Autowired
	public ProductService(ProductDAOInterface productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public Iterable<Product> getAll() {
		return productDAO.findAll();
	}

	@Override
	public Product getById(int id) {		
		return productDAO.findById(id);
	}

	@Override
	public Product getByName(String name) {		
		return productDAO.findByName(name);
	}

	@Override
	public Product add(Product product) {
		return productDAO.save(product);
	}

	@Override
	public void update(Product product) {
		productDAO.save(product);
	}

	@Override
	public void delete(int id) {
		productDAO.deleteById(id);
	}

}
