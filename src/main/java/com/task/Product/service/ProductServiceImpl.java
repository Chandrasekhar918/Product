package com.task.Product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Product.entity.Product;
import com.task.Product.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepo productRepo;

	@Override
	public String addProduct(Product product) {
		productRepo.save(product);
		return "Product added Successfully with id"+ product.getId() ;
	}

	@Override
	public List<Product> findallProducts() {
		return productRepo.findAll();
		
	}

	@Override
	public Product findProduct(int id) {
	return productRepo.findById(id).get();
		
	}
	  @Override
	    public String deleteProduct(int id)  {
	        productRepo.deleteById(id);
	        return "Product Deleted Successfuly with id"+id;
	    }


	@Override
	public String updateProduct(int id, Product product) {
		Optional<Product> Container = productRepo.findById(id);
		if(Container.isPresent()) {
			Product n=Container.get();
			n.setId(product.getId());
			n.setProduct_name(product.getProduct_name());
			n.setColor(product.getColor());
			n.setDescription(product.getDescription());
			n.setPrice(product.getPrice());
			productRepo.save(n);
			return "Product updated succesfully with id"+ id;
		}
		else {
			return "Id not found";
		}
		
	}

}
