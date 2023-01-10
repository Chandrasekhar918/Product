package com.task.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.Product.entity.Product;
import com.task.Product.repo.ProductRepo;
import com.task.Product.service.ProductService;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;


	@Test
	 @DisplayName("Find all Products Test")
	 public void FindAllProductsTest() {
		when(productRepo.findAll()).thenReturn(Stream
				.of(new Product(1, "Acer Laptop","Black","acer 21.5 inch Full HD ",76000),new Product(2, "Acer Laptop","Black","acer 21.5 inch Full HD ",76000)).collect(Collectors.toList()));
				assertEquals(2, productService.findallProducts().size());
	}

	@Test 
	@DisplayName("Update Product Test")
	public void updateProductTest() {
		Product product=new Product(1, "Acer Laptop","Black","acer 21.5 inch Full HD ",76000);
		
		when(productRepo.save(product)).thenReturn(product);
		int id=product.getId();
		product.setColor("green");
		productService.updateProduct(id, product);
		
		Assertions.assertThat(product.getColor().equals("green"));
	}
	@Test
	@DisplayName("Delete Product Test")
	public void DeleteFlightTest() {
		Product product=new Product(1, "Acer Laptop","Black","acer 21.5 inch Full HD ",76000);
		productService.deleteProduct(product.getId());
		assertEquals(0,productService.findallProducts().size());
	}

}
