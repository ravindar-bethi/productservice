package com.dell.cloud.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dell.cloud.productservice.entity.Product;
import com.dell.cloud.productservice.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateStock(Long id, int stock) {
		Product product = productRepository.findById(id).orElse(null);
		if (product != null) {
			product.setStock(stock);
			return productRepository.save(product);
		}
		return null;
	}

}
