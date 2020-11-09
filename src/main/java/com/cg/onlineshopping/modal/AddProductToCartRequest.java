package com.cg.onlineshopping.modal;

import javax.validation.constraints.NotBlank;

public class AddProductToCartRequest {
	@NotBlank
	private String cartId;
	@NotBlank
	private String userId;
	private int productId;
	private int  quantity;

	
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	

}
