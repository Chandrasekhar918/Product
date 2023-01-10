package com.task.Product.service;

import java.util.List;

import com.task.Product.entity.Product;

public interface ProductService {

public String addProduct(Product product);
public List<Product> findallProducts();
public Product findProduct(int id);
public String deleteProduct(int id);
public String updateProduct(int id,Product product);
}
