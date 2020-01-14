package com.cognizant.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.model.MovieList;
import com.cognizantmovie.dao.MovieListDao;
import com.cognizantmovie.dao.MovieListDaoSqlImpl;

@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public ShowMovieListAdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDao movieListDao = new MovieListDaoSqlImpl();
		List<MovieList> movieList = movieListDao.getMovieListAdmin();
		request.setAttribute("movieList", movieList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie-list-admin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
