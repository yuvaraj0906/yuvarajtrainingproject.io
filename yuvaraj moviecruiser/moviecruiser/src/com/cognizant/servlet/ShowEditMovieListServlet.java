package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.model.MovieList;
import com.cognizantmovie.dao.MovieListDao;
import com.cognizantmovie.dao.MovieListDaoSqlImpl;

@WebServlet("/ShowEditMovieList")
public class ShowEditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditMovieListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		Long movieListId = Long.parseLong(request.getParameter("id"));
		MovieList movieList = movieListDao.getMovies(movieListId);

		request.setAttribute("movieList", movieList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movie.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
