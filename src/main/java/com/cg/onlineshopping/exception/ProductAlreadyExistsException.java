package com.cg.onlineshopping.exception;

public class ProductAlreadyExistsException extends Exception {

	/**
	 * product already exists exception
	 */
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistsException() {
	}

	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}

}
