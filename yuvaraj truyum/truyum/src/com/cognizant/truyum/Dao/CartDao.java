package com.cognizant.truyum.Dao;

import com.cognizant.truyum.model1.Cart;

public interface CartDao {

	public void addCartItems(long userId, long menuItemId);

	public Cart getAllCartItems(long userId) throws CartEmptyException;

	public void removeCartItem(long userId, long MenuItemId);
}
