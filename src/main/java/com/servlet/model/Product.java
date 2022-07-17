package com.servlet.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Product {
	private String id, name;
	private int quantity;
	private double price;
	private Date releaseDate;
	private String describe, image;
	private Category category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, int quantity, double price, String releaseDate, 
			String describe, String image, Category category) throws ParseException {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.releaseDate =  new SimpleDateFormat("yy-mm-dd").parse(releaseDate);
		this.describe = describe;
		this.image = image;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReleaseDate() {
		return releaseDate.toString();
	}

	public void setReleaseDate(String releaseDate) throws ParseException {
		this.releaseDate = (Date) new SimpleDateFormat("dd/mm/yy").parse(releaseDate);
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
