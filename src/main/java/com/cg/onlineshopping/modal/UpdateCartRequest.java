package com.cg.onlineshopping.modal;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cg.onlineshopping.entities.Product;

public class UpdateCartRequest {
	@NotBlank
	@Size(min = 2, max = 20)
	private String cartId;
	@NotBlank
	@Size(min = 2, max = 20)
    private String userId;
	@NotBlank
	@Size(min = 2, max = 20)
    private Map<Product, Integer> products;
	@NotBlank
	private int productId;
	@NotBlank
	private int  quantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

}
