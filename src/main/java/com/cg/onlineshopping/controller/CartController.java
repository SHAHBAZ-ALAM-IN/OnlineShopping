package com.cg.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.CartAlreadyExistsException;
import com.cg.onlineshopping.exception.CartNotFoundException;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.modal.AddProductToCartRequest;
import com.cg.onlineshopping.modal.CartDetails;
import com.cg.onlineshopping.modal.UpdateCartRequest;
import com.cg.onlineshopping.service.ICartService;
import com.cg.onlineshopping.service.IProductService;
import com.cg.onlineshopping.util.CartUtil;

@Validated
@RequestMapping("/user")
@RestController
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	@Autowired
	private ICartService  cartService;
	@Autowired
	private IProductService productService;
	@Autowired
	private CartUtil cartUtil;
	
	@PostMapping("/add")
		public ResponseEntity<CartDetails> addProductToCart(@RequestBody @Valid AddProductToCartRequest requestData)
				throws CartAlreadyExistsException {
			try {
				 Cart cart=cartService.viewCart(requestData.getCartId());
				 Product product=productService.viewProduct(requestData.getProductId());
				cart = cartService.addProductToCart(cart,product, requestData.getQuantity());
				CartDetails details = cartUtil.toDetails(cart);
				return new ResponseEntity<>(details, HttpStatus.OK);
			} catch (Exception e) {
				LOGGER.error("unable to add cart:{} errorlog: ", requestData.getCartId(), e);
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	
	@DeleteMapping("/remove/{cartId}/{productId}")
	public ResponseEntity<CartDetails>  removeProductFromCart(@PathVariable("cartId")String cartId,@PathVariable("productId")int productId)
			throws CartNotFoundException, ProductNotFoundException {
		try {
			Cart cart=cartService.viewCart(cartId);
			Product product=productService.viewProduct(productId);
			cart=cartService.removeProductFromCart(cart,product);
			CartDetails cartDetail=cartUtil.toDetails(cart);
			return new ResponseEntity<CartDetails>(cartDetail,HttpStatus.OK);
		} catch (CartNotFoundException e) {
			LOGGER.error("unable to delete cart for cartId:{} errlog", cartId );
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	@PutMapping("/update")
	public ResponseEntity<CartDetails> updateProductQuantity(@RequestBody @Valid UpdateCartRequest requestData)
			throws CartNotFoundException {
		try {
			
			Cart cart=cartService.viewCart(requestData.getCartId());
			Product product=productService.viewProduct(requestData.getProductId());
			cart = cartService.updateProductQuantity(cart,product,requestData.getQuantity());
			CartDetails details = cartUtil.toDetails(cart);
			
			/*Cart cart = new Cart(requestData.getCartId(), requestData.getUserId(), requestData.getProducts());
			cart.setCartId(requestData.getCartId());
			cart = cartService.updateProductQuantity(cart,product,quantity);
			CartDetails details = cartUtil.toDetails(cart);*/
			return new ResponseEntity<>(details, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("unable to update cart for CartId:{} errlog: ", requestData.getCartId(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	@RequestMapping("/viewall")
	public ResponseEntity<List<Product>>  viewAllProducts(Cart cart) {
		try {
			return new ResponseEntity<>(cartService.viewAllProducts(cart), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("unable to view all the products: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


