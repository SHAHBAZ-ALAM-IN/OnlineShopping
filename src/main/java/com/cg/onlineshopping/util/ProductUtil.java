package com.cg.onlineshopping.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.modal.ProductDetails;

@Component
public class ProductUtil {
	public List<ProductDetails> toDetails(Collection<Product> product) {
		List<ProductDetails> desired = new ArrayList<>();
		for (Product add : product) {
			ProductDetails details = toDetails(add);
			desired.add(details);
		}
		return desired;
	}

	public ProductDetails toDetails(Product product) {
		return new ProductDetails(product.getProductId(), product.getProductName(), product.getPrice(),
				product.getColor(), product.getDimension(), product.getSpecification(), product.getManufacturer(), product.getQuantity() ,product.getCategory());
		
	}
	
	public List<ProductDetails> toDetails(List<Product> productList)
    {
        List<ProductDetails> productModelList = new ArrayList<>();
        for(Product product: productList)
        {
            productModelList.add(toDetails(product));
        }
        return productModelList;
    }
	
}
