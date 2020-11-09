package com.cg.onlineshopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.ProductAlreadyExistsException;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.IProductService;


@Transactional
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository repo;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> viewAllProducts() {
		LOGGER.info("retreving all the address");
		List<Product> products = new ArrayList<>();
		repo.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product addProduct(Product product) throws ProductAlreadyExistsException {
		LOGGER.info("adding product for user with productId:{}", product.getProductId());
		boolean exists=product.getProductId()!=0 && repo.existsById(product.getProductId());
		if(exists) {
			throw new ProductAlreadyExistsException(
			String.format("address already exists for id= %d", product.getProductId()));
		}
	
		product=repo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException{
		LOGGER.info("updating product with productId: {}", product.getProductId());
		boolean exists = product.getProductId() != 0 && repo.existsById(product.getProductId());
		if (!exists) {
			throw new ProductNotFoundException("Can't find, product not found for id=" + product.getProductId());
		}
		return repo.save(product);
		
	}

	@Override
	public Product viewProduct(int id) throws ProductNotFoundException {
		LOGGER.info("viewing product with productId:{}", id);
		Optional<Product> optional = repo.findById(id);
		if (!optional.isPresent())
			throw new ProductNotFoundException("Can't find, product not found for id=" + id);
		return optional.get();
		
	}

	@Override
	public List<Product> viewProductsByCategory(String catId) {
		return repo.findByCatId(catId);
		 
		 }

	@Override
	public Product removeProduct(int productId) throws ProductNotFoundException {
		LOGGER.info("removing product with productId: {}", productId);
		Product deletedProduct = viewProduct(productId);
		repo.delete(deletedProduct);
		return deletedProduct;
		
		
	}

}
