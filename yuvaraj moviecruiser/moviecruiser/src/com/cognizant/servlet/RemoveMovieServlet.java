package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizantmovie.dao.FavouritesDao;
import com.cognizantmovie.dao.FavouritesDaoSqlImpl;
import com.cognizantmovie.dao.MoviesEmptyException;

@WebServlet("/RemoveMovie")
public class RemoveMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveMovieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = 1;
		Long menuItemId = Long.parseLong(request.getParameter("id"));
		FavouritesDao cartDao = new FavouritesDaoSqlImpl();
		cartDao.removeFavouritesMovies(userId, menuItemId);
		try {
			request.setAttribute("cart", cartDao.getAllFavouritesMovies(userId));
			request.setAttribute("message", true);
			request.getRequestDispatcher("Favourites.jsp").forward(request, response);
			request.setAttribute("addMovieStatus", true);
		} catch (MoviesEmptyException e) {
			request.getRequestDispatcher("movies-empty.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
