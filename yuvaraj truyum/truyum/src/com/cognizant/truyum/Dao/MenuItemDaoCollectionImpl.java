package com.cognizant.truyum.Dao;

import com.cognizant.truyum.util.DateUtil;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import com.cognizant.truyum.model1.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem itemOne = new MenuItem(1L, "sandwhich", 99.00f, true, new DateUtil().convertToDate("23/12/2020"),"MainCourse", false);
			MenuItem itemTwo = new MenuItem(2L, "burger", 129.00f, true, new DateUtil().convertToDate("23/12/2017"),"MainCourse", false);
			MenuItem itemThree = new MenuItem(3L, "pizza", 149.00f, true, new DateUtil().convertToDate("13/12/2020"),"MainCourse", false);
			MenuItem itemFour = new MenuItem(4L, "frenchfries", 57.00f, true,new DateUtil().convertToDate("02/07/2020"), "Starters", true);
			MenuItem itemFive = new MenuItem(5L, "chocolatebrownie", 32.00f, true,new DateUtil().convertToDate("02/12/2017"), "Dessert", true);
			menuItemList.add(itemOne);
			menuItemList.add(itemTwo);
			menuItemList.add(itemThree);
			menuItemList.add(itemFour);
			menuItemList.add(itemFive);
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().after(new Date())) {
				if (menuItem.getActive()) {
					filteredMenuItem.add(menuItem);
				}
			}
		}
		return filteredMenuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
			}
		}
	}

	@Override
	public MenuItem getmenuItem(Long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return null;
	}
}
