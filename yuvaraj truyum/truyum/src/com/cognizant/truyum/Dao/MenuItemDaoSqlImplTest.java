package com.cognizant.truyum.Dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import com.cognizant.truyum.model1.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");

		List<MenuItem> userList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATE-OF-LAUNCH",
				"CATEGORY", "FREE-DELIVERY");
		for (MenuItem us : userList) {
			System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", us.getId(), us.getName(),
					df.format(us.getPrice()), us.getActive(), sdf.format(us.getDateOfLaunch()), us.getCategory(),
					us.getFreeDelivery());
		}
	}

	public static void testGetMenuItemListCustomer() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");

		List<MenuItem> userList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATE-OF-LAUNCH",
				"CATEGORY", "FREE-DELIVERY");
		for (MenuItem us : userList) {
			System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", us.getId(), us.getName(),
					df.format(us.getPrice()), us.getActive(), sdf.format(us.getDateOfLaunch()), us.getCategory(),
					us.getFreeDelivery());
		}
	}

	public static void testModifyMenuItemListAdmin() {
		MenuItem menuItem = new MenuItem(4L, "dosa", 99.00f, true, new DateUtil().convertToDate("23/12/2020"),"MainCourse", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
	}
 
	public static void testgetMenuItem() {
		System.out.println("\nEnter the id");
		long menuItemId=3;
		MenuItem menu_item = new MenuItemDaoSqlImpl().getmenuItem(menuItemId);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df= new DecimalFormat("#.00");
		System.out.format("%-5s%-25s%-15s%-15s%-15s%-15s%-15s\n", menu_item.getId(), menu_item.getName(),
				df.format(menu_item.getPrice()), menu_item.getActive(), sdf.format(menu_item.getDateOfLaunch()), menu_item.getCategory(),
				menu_item.getFreeDelivery());
	}
	public static void main(String[] args) {

		ConnectionHandler.getConnection();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItemListAdmin();
		testgetMenuItem();
		
	}
}
