package com.cognizant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.model.MovieList;
import com.cognizantmovie.dao.FavouritesDao;
import com.cognizantmovie.dao.FavouritesDaoSqlImpl;
import com.cognizantmovie.dao.MovieListDao;
import com.cognizantmovie.dao.MovieListDaoSqlImpl;

@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToFavoritesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = 1;
		Long movieListId = Long.parseLong(request.getParameter("movieListId"));
		FavouritesDao cartDao = new FavouritesDaoSqlImpl();
		cartDao.addFavouritesMovies(userId, movieListId);
		MovieListDao menuItemDao = new MovieListDaoSqlImpl();
		List<MovieList> menuItemListCustomer = menuItemDao.getMovieListCustomer();
		request.setAttribute("menuItem", menuItemListCustomer);
		request.setAttribute("addCartStatus", true);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
