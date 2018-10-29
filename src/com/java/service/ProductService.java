package com.java.service;

import java.util.List;

import com.java.dto.Product;

public interface ProductService {
	public void addProduct(Product p);
	
	public void deleteProduct(Product p);
	
	public void updateProduct(Product p);
	
	public Product getProduct(int id);
	
	public List<Product> getAllProducts();
	
}
