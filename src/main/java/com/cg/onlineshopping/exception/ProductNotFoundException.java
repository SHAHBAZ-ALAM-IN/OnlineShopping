package com.cg.onlineshopping.exception;

public class ProductNotFoundException extends Exception{

	/**
	 * product not found exception
	 */
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException() {}
	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
