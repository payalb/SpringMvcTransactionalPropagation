package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.Product;
import com.java.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired ProductService service;

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute Product product) {
		service.addProduct(product);
		return "redirect:/viewProducts";
	}
	
	@GetMapping("/viewProducts")
	public String viewProducts(Model model) {
		model.addAttribute("products", service.getAllProducts());
		return "viewProducts";
	}
}
