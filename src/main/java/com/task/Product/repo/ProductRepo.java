package com.task.Product.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.task.Product.entity.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product,Integer> {

}
