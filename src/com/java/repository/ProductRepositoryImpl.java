package com.java.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Product;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired HibernateTemplate template;
	@Override
	public void addProduct(Product p) {
		template.save(p);
	}

	@Override
	public void deleteProduct(Product p) {
		template.delete(p);
	}

	@Override
	public void updateProduct(Product p) {
		template.update(p);
	}

	@Override
	public Product getProduct(int id) {
		return template.get(Product.class, id);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) template.findByCriteria(DetachedCriteria.forClass(Product.class));
	}

}
