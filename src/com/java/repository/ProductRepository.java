package com.java.repository;

import java.util.List;

import com.java.dto.Product;

public interface ProductRepository {

	public void addProduct(Product p);
	
	public void deleteProduct(Product p);
	
	public void updateProduct(Product p);
	
	public Product getProduct(int id);
	
	public List<Product> getAllProducts();
	
}
