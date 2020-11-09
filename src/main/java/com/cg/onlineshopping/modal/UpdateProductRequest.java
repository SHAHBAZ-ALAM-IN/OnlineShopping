package com.cg.onlineshopping.modal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cg.onlineshopping.entities.Category;

public class UpdateProductRequest {
	@NotBlank
	@Size(min = 2, max = 20)
	private Integer productId;

	@NotBlank
	@Size(min = 2, max = 20)
	private String productName;

	@NotBlank
	@Size(min = 2, max = 20)
	private double price;

	@NotBlank
	@Size(min = 2, max = 20)
	private String color;

	@NotBlank
	@Size(min = 2, max = 20)
	private String dimension;

	@NotBlank
	@Size(min = 2, max = 20)
	private String specification;

	@NotBlank
	@Size(min = 2, max = 20)
	private String manufacturer;

	@NotBlank
	@Size(min = 2, max = 20)
	private int quantity;

	@NotBlank
	@Size(min = 2, max = 20)
	private Category category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
