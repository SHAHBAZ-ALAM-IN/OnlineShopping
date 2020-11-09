package com.cg.onlineshopping.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{
	@Query("FROM Product WHERE catId=:catId")
    List<Product> findByCatId(@Param("catId") String catId);
	
}
