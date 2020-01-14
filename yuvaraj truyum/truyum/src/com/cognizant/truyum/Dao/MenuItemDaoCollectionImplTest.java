package com.cognizant.truyum.Dao;

import java.util.List;

import com.cognizant.truyum.util.DateUtil;

import com.cognizant.truyum.model1.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem item = new MenuItem(5L, "Briyani", 52.00f, true, new DateUtil().convertToDate("02/12/2017"),
				"Main course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(item);
		System.out.println("***Modified List***");
		testGetMenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getmenuItem(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

}
