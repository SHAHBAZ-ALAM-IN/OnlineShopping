package com.cg.onlineshopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.CartNotFoundException;
import com.cg.onlineshopping.repository.ICartRepository;
import com.cg.onlineshopping.service.ICartService;

@Transactional
@Service
public class CartServiceImpl implements ICartService {

	/**
	 * This is the method which contains all the implementation of interface class
	 * ICartService
	 *
	 * @param entityManager object manages a set of entities that are defined by a
	 *                      persistence unit.
	 * @param repo          used to call the ICartRepository
	 */
	@Autowired
	private ICartRepository repo;
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	/**
	  */

	@Override
	public Cart addProductToCart(Cart cart, Product product, int quantity) {
		LOGGER.info("adding product with cartId:{}", cart.getCartId());
		
		Map<Product, Integer> products = cart.getProducts();
        if (products == null) {
            products = new HashMap<>();
            cart.setProducts(products);
        }
     
        products.put(product, quantity);

        cart=repo.save(cart);
        System.out.println("*******cart id="+cart.getCartId());
        return cart;
		

	}



	/**
	 * This method is used to remove the product from cart. we can remove products
	 * of cart via this method
	 *
	 * @return carts used to return the cart.
	 */
	@Override
	public Cart removeProductFromCart(Cart cart, Product product) throws CartNotFoundException {
		LOGGER.info("removing Cart from cartid : {}", cart.getCartId(), "removing product : {}", cart.getProducts());
		 cart = viewCart(cart.getCartId());
		Map<Product, Integer> products =cart.getProducts();
		if(products!=null) {
		products.remove(product);
		cart=repo.save(cart);
		}
		return cart;
		

	}

	/**
	 * This method is used to update to cart. we can update cart via this method
	 *
	 * @return carts used to return the updated cart.
	 * @throws CartNotFoundException 
	 */
	@Override
	public Cart updateProductQuantity(Cart cart, Product product, int quantity) throws CartNotFoundException  {
		LOGGER.info("updating product quantity  with cartId: {}", cart.getCartId());
		cart=viewCart(cart.getCartId());
		Map<Product, Integer> products = cart.getProducts();
        if (products != null) {
            products.put(product, quantity);
            cart=repo.save(cart);
        }
        return cart;
	}

	/**
	 * This method is used to remove all products from the cart. we can remove all
	 * products via this method
	 *
	 * @return carts used to remove all the products in cart.
	 */
	@Override
	public Cart removeAllProducts(Cart cart) {

		 Map<Product, Integer> products = cart.getProducts();
	        if (products != null) {
	            products.clear();
	            cart =repo.save(cart);
	        }
	        return cart;

	}

	/**
	 * This method is used to commit changes to cart. we can view all the products
	 * in cart via this method
	 *
	 * @return list is used to print all the product in cart.
	 * @throws CartNotFoundException 
	 */
	@Override
	public List<Product> viewAllProducts(Cart cart) throws CartNotFoundException {
		LOGGER.info("retreving all the products from cart");
		cart=viewCart(cart.getCartId());
		Map<Product, Integer> productsMap = cart.getProducts();
        Set<Product> products = productsMap.keySet();
        List<Product> list = new ArrayList<>(products);
        return list;
		
		

	}

	public Cart viewCart(String cartId) throws CartNotFoundException {
		LOGGER.info("viewing cart with cartId:{}", cartId);
		Optional<Cart> optional = repo.findById(cartId);
		if (!optional.isPresent())
			throw new CartNotFoundException("Can't find, address not found for id=" + cartId);
		return optional.get();
	}

}
