package com.cognizant.truyum.Dao;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.cognizant.truyum.model1.Cart;
import com.cognizant.truyum.model1.MenuItem;

public class CartItemDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartItemDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItems(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuitem = menuItemDao.getmenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuitem);
		} else {
			Cart cart = new Cart();
			ArrayList<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuitem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		}
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		double total = 0.0f;
		if (userCarts == null || cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();
		}
		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long MenuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == MenuItemId) {
				menuItemList.remove(i);
				return;
			}
		}
	}
}