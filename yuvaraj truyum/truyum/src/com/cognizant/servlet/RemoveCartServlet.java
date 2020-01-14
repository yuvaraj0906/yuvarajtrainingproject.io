package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.truyum.Dao.CartDao;
import com.cognizant.truyum.Dao.CartDaoSqlImpl;
import com.cognizant.truyum.Dao.CartEmptyException;
import com.cognizant.truyum.model1.Cart;

@WebServlet("/RemoveCart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1l;
		Long menuItemId = Long.parseLong(request.getParameter("menuItemId"));

		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(userId, menuItemId);
		try {
			Cart cart = cartDao.getAllCartItems(userId);
			request.setAttribute("cart", cart);
			request.setAttribute("addCartStatus", true);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} catch (CartEmptyException e) {
			request.getRequestDispatcher("cart-empty.jsp").forward(request, response);
		}

	}
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
