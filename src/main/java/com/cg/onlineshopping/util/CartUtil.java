package com.cg.onlineshopping.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.modal.CartDetails;
import com.cg.onlineshopping.modal.ProductDetails;

@Component
public class CartUtil {
	@Autowired
	private ProductUtil productUtil;
	public List<CartDetails> toDetails(Collection<Cart> carts) {
		List<CartDetails> desired = new ArrayList<>();
		for (Cart add : carts) {
			CartDetails details = toDetails(add);
			desired.add(details);
		}
		return desired;
	}
	public CartDetails toDetails(Cart cart) {
		Map<ProductDetails, Integer> desired=new HashMap<>();
		Map<Product, Integer> map=cart.getProducts();
		Set<Product> products =map.keySet();
		for(Product product:products) {
			int quantity=map.get(product);
			ProductDetails productDetail=productUtil.toDetails(product);
			desired.put(productDetail,quantity);
		}
			
		return new CartDetails(cart.getCartId(),cart.getUserId(), desired);
	}
}
