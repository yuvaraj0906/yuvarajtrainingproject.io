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

@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowCartServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long userId = 1l;
		CartDao cartDao = new CartDaoSqlImpl();
		try {
			Cart cart = cartDao.getAllCartItems(userId);
			request.setAttribute("cart", cart);
			request.setAttribute("message", true);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} catch (CartEmptyException e) {
			request.getRequestDispatcher("cart-empty.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
