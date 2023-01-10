package com.task.Product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.Product.entity.Product;
import com.task.Product.service.ProductService;
@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product) ;
		
	}
	
	@GetMapping("/findall")
	public List<Product> findAllProducts(){
		return productService.findallProducts();
	}
	
	@GetMapping("/find/{id}")
	public Product findProduct(@PathVariable int id) {
		return productService.findProduct(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}


	
	
}
