package com.lakhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakhan.model.Product;


import com.lakhan.service.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	
	    private  ProductService productService;
	  

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @PostMapping
	    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    	
	    	
	        Product newProduct = productService.addProduct(product);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	    }

	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return ResponseEntity.ok(products);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Product product = productService.getProductById(id);
	     
	        if (product != null) {
	        	
	            return ResponseEntity.ok(product);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }



	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        Product product = productService.updateProduct(id, updatedProduct);
	        if (product != null) {
	            return ResponseEntity.ok(product);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long productid) {
	        if (productService.deleteProduct(productid)) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
