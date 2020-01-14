package com.cognizant.truyum.Dao;

import java.util.List;

import com.cognizant.truyum.model1.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getmenuItem(Long menuItemId);
}
