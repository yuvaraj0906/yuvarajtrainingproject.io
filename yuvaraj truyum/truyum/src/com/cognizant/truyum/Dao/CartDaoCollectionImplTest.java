package com.cognizant.truyum.Dao;



import com.cognizant.truyum.model1.Cart;
import com.cognizant.truyum.model1.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {

		CartDao cartDao = new CartItemDaoCollectionImpl();
		cartDao.addCartItems(1, 2L);
		cartDao.addCartItems(1, 5L);
		cartDao.addCartItems(2, 2L);
		cartDao.addCartItems(2, 3L);
		Cart menuItemListCustomer = cartDao.getAllCartItems(2);
		System.out.println("User added cart List for Checkout");
		for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {

		CartDao cartDao = new CartItemDaoCollectionImpl();
		System.out.println("After removing the item");
		try {
			cartDao.removeCartItem(1, 2L);
			// cartDao.removeCartItem(1, 5L);
			// cartDao.addCartItems(2, 2L);
			// cartDao.addCartItems(2, 3L);
			Cart menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();
		testRemoveCartItem();
	}
}
