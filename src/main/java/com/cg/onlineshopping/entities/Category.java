package com.cg.onlineshopping.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "category")
/**
 * The Category program contains all the entities and constructor method that
 * call all the variable in Category
 * 
 * @author prakhar gupta
 * @version 1.0
 * @since 2020-10-19
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * This constructor is used to initialize objects of Product class.
	 * 
	 * @Id Specifies the primary key of an entity
	 * @Entity defines that a class can be mapped to a table
	 * @OneToOne defines the one to one relationship
	 * @Column permits the name of the column to be explicitly specified
	 * @param catId        this is the catId for Category method
	 * @param categoryName this is the categoryName for Category method
	 */

	@Id
	private String catId;

	private String categoryName;

	public Category() {

	}

	public Category(String catId, String categoryName) {

		this.catId = catId;
		this.categoryName = categoryName;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
