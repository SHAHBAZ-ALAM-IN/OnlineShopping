package com.cg.onlineshopping.service;
import java.util.List;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.CartAlreadyExistsException;
import com.cg.onlineshopping.exception.CartNotFoundException;

public interface ICartService {
	public Cart addProductToCart(Cart cart, Product p,int quantity) throws CartAlreadyExistsException;
	public Cart removeProductFromCart(Cart cart,Product p) throws CartNotFoundException;
	public Cart updateProductQuantity(Cart cart, Product p,int quantity)  throws CartNotFoundException;;
	public Cart removeAllProducts(Cart cart);
	public List<Product> viewAllProducts(Cart cart) throws CartNotFoundException;
	public Cart viewCart(String cartId) throws CartNotFoundException;

}
