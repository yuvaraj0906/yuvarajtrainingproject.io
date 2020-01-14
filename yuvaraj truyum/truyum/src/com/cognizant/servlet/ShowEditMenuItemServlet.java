package com.cognizant.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.truyum.Dao.MenuItemDao;
import com.cognizant.truyum.Dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model1.MenuItem;

@WebServlet("/ShowEditMenuItem")
public class ShowEditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowEditMenuItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			Long menuItemId = Long.parseLong(request.getParameter("id"));

			MenuItem menuItem = menuItemDao.getmenuItem(menuItemId);
			request.setAttribute("menuItem", menuItem);

			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
