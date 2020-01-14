package com.cognizant.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.truyum.Dao.CartDao;
import com.cognizant.truyum.Dao.CartDaoSqlImpl;
import com.cognizant.truyum.Dao.MenuItemDao;
import com.cognizant.truyum.Dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model1.MenuItem;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long userId = 1l;
		Long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItems(userId, menuItemId);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();
		request.setAttribute("menuItem", menuItemListCustomer);
		request.setAttribute("addCartStatus", true);
		request.getRequestDispatcher("menu-item-list-customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
