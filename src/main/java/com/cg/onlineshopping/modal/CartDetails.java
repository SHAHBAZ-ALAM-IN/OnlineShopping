package com.cg.onlineshopping.modal;

import java.util.Map;

public class CartDetails {
	private String cartId;
    private String userId;
    private Map<ProductDetails, Integer> products;
    
    public CartDetails() {
		 
	 }
   public CartDetails(String cartId, String userId, Map<ProductDetails, Integer> products) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.products = products;
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
	
	
	 public Map<ProductDetails, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductDetails, Integer> products) {
		this.products = products;
	}
	

}
