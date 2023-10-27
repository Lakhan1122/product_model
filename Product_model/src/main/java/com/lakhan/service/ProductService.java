package com.lakhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakhan.exception.ProductNotFoundException;
import com.lakhan.model.Product;
import com.lakhan.repository.ProductRepository;

@Service
public class ProductService {
	
	
	
	    private  ProductRepository productRepository;

	    @Autowired
	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long productid) {
	    	Product product = productRepository.findById(productid)
	                .orElseThrow(() -> new ProductNotFoundException(productid));
	        return product;
	    }

	    public Product addProduct(Product product) {
	    	
	   
	    	
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Long id, Product updatedProduct) {
	        Product existingProduct = productRepository.findById(id).orElse(null);
	        if (existingProduct != null) {
	            existingProduct.setName(updatedProduct.getName());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            // Update other fields as needed
	            return productRepository.save(existingProduct);
	        }
	        return null;
	    }

	    public boolean deleteProduct(Long id) {
	        if (productRepository.existsById(id)) {
	            productRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
