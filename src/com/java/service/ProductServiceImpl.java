package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Product;
import com.java.repository.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired ProductRepository rep;

	@Override
	public void addProduct(Product p) {
		rep.addProduct(p);
		
	}

	@Override
	public void deleteProduct(Product p) {
		rep.deleteProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		rep.updateProduct(p);
	}

	@Transactional(readOnly=true)
	@Override
	public Product getProduct(int id) {
		
		return rep.getProduct(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Product> getAllProducts() {
		return rep.getAllProducts();
	}
}
