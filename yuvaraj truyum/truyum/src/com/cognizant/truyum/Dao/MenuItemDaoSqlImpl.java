package com.cognizant.truyum.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model1.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String MENUITEM_ALL_DETAILS = "select * from menu_item ";
	public static final String MODIFY_MENUITEM = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?";
	public static final String MENUITEM_CUSTOMER_DETAILS = "select * from truyum.menu_item where menu_item.me_date_of_launch>curdate() and me_active='yes'; ";
	public static final String GET_MENUITEM = "select*from truyum.menu_item where menu_item.me_id=1";
	
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(MENUITEM_ALL_DETAILS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(MENUITEM_CUSTOMER_DETAILS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}
		return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(MODIFY_MENUITEM);
			statement.setString(1, menuItem.getName());
			statement.setFloat(2, menuItem.getPrice());
			statement.setString(3, menuItem.getActive() ? "yes" : "no");
			new DateUtil();
			statement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			statement.setString(5, menuItem.getCategory());
			statement.setString(6, menuItem.getFreeDelivery() ? "yes" : "no");
			statement.setLong(7, menuItem.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MenuItem getmenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MenuItem menu_item = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MENUITEM);
			preparedstatement.setLong(1, menuItemId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultset.getLong("me_id"));
				menuItem.setName(resultset.getString("me_name"));
				menuItem.setPrice(resultset.getFloat("me_price"));
				menuItem.setActive(resultset.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menuItem.setCategory(resultset.getString("me_category"));
				menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu_item;
	}
}
