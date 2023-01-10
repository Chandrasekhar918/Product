package com.task.Product.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;



@Document(collection="ProductDetails")
public class Product {
@Id	
private int id;
private String product_name;
private String color;
private String description;
private double price;

public Product() {
	super();
}

public Product(int id, String product_name, String color, String description, double price) {
	super();
	this.id = id;
	this.product_name = product_name;
	this.color = color;
	this.description = description;
	this.price = price;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id =id;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

}
