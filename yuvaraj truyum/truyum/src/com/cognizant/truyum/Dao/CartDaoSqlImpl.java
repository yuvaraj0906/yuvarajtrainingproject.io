package com.cognizant.truyum.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.truyum.model1.Cart;
import com.cognizant.truyum.model1.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_TO_CART = "insert into truyum.cart(ct_us_id,ct_pr_id)values(?,?)";
	public static final String GET_CARTITEM = "SELECT menu_item.me_id,menu_item.me_name,menu_item.me_price,menu_item.me_active,menu_item.me_date_of_launch,menu_item.me_category,menu_item.me_free_delivery from cart\r\n"
			+ "inner join menu_item on menu_item.me_id=cart.ct_pr_id\r\n"
			+ "inner join user on user.us_id=cart.ct_us_id\r\n" + "where user.us_id=?;\r\n";
	public static final String GET_TOTAL = "SELECT user.us_id,sum(menu_item.me_price) as me_total from cart\r\n"
			+ "inner join menu_item on menu_item.me_id=cart.ct_pr_id\r\n"
			+ "inner join user on user.us_id=cart.ct_us_id\r\n" + "where user.us_id=?";
	public static final String REMOVE_FROM_CART = "delete from cart where ct_us_id=? and ct_pr_id=? limit 1";
	
	@Override
	public void addCartItems(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);

			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		Cart cart = new Cart();
		try {
			preparedStatement = connection.prepareStatement(GET_CARTITEM);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			double total = 0.0;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getDouble("me_total");
			}
			cart.setTotal(total);
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
				if (preparedStatementTotal != null) {
					preparedStatementTotal.close();
				}
			} catch (SQLException e) {
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long MenuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_FROM_CART);
			statement.setLong(1, userId);
			statement.setLong(2, MenuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}
	}
}
