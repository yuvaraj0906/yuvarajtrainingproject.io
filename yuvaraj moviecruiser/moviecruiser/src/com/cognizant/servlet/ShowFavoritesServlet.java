package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.model.Favourites;
import com.cognizantmovie.dao.FavouritesDao;
import com.cognizantmovie.dao.FavouritesDaoSqlImpl;
import com.cognizantmovie.dao.MoviesEmptyException;

@WebServlet("/ShowFavorites")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowFavoritesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavouritesDao CartDao = new FavouritesDaoSqlImpl();
		int userId = 1;

		try {
			Favourites cart = CartDao.getAllFavouritesMovies(userId);
			request.setAttribute("cart", cart);
			request.setAttribute("message",true);
			System.out.println("Successs.........");
			request.getRequestDispatcher("Favourites.jsp").forward(request, response);

		} catch (MoviesEmptyException e) {
			request.getRequestDispatcher("movies-empty.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
