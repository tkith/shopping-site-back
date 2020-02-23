package com.tkith.shoppingsite.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tkith.shoppingsite.entity.Product;
import com.tkith.shoppingsite.exception.ProductNotFoundException;
import com.tkith.shoppingsite.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API for CRUD operations on Products.")
@RestController
@RequestMapping("/api")
public class ProductController {
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@ApiOperation("Get all Products.")
	@GetMapping("/products")
	public Iterable<Product> getAll() {
		return productService.getAll();
	}
	
	@ApiOperation("Get a Product by ID.")
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		Product product = productService.getById(id);
		
		if (product == null) {
			throw new ProductNotFoundException("There is no product with id = " + id);
		}
		
		return product;
	}
	
	@ApiOperation("Get a Product by name.")
	@RequestMapping(value = "/products", params="name", method = RequestMethod.GET)
	public Product getProductByName(@RequestParam("name") String name) {
		Product product = productService.getByName(name);
		
		if (product == null) {
			throw new ProductNotFoundException("There is no product with name = " + name);
		}
		
		return productService.getByName(name);	
	}
	
	@ApiOperation("Add a Product.")
	@PostMapping("/products")
	public ResponseEntity<Void> add(@Valid @RequestBody Product product) {
		Product productAdded = productService.add(product);
		
		if (productAdded == null)
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
	}
	
	@ApiOperation("Update a Product.")
	@PutMapping("/products")
	public void update(@RequestBody Product product) {
		productService.update(product);
	}
	
	@ApiOperation("Delete a Product.")
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable int id) {
		productService.delete(id);
	}
}
