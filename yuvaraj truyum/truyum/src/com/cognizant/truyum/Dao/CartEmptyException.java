package com.cognizant.truyum.Dao;

public class CartEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	public CartEmptyException() {
		super("cart list is empty");
	}
}
