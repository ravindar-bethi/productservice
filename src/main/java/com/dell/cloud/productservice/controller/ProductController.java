package com.dell.cloud.productservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dell.cloud.productservice.entity.Product;
import com.dell.cloud.productservice.service.ProductService;

@RestController
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	@PostMapping
	public Product addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@PutMapping("/{id}/stock")
	public Product updateStock(@PathVariable Long id, @RequestParam int stock) {
		return productService.updateStock(id, stock);
	}
}
