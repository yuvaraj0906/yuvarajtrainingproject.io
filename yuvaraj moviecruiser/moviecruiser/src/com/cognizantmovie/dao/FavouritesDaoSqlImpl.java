package com.cognizantmovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.MovieList;

public class FavouritesDaoSqlImpl implements FavouritesDao {
	public static final String ADD_MOVIESTO_FAVORITE = "insert into favourites(fv_us_id,fv_gr_id) values(?,?)";
	
	public static final String GET_CART = "select movie_list.mo_id,movie_list.mo_title,movie_list.mo_gross,movie_list.mo_active,movie_list.mo_genre,movie_list.mo_date_of_launch,movie_list.mo_has_teaser from favourites\r\n"
			+ "inner join movie_list on movie_list.mo_id=favourites.fv_gr_id\r\n"
			+ "inner join user on user.us_id=favourites.fv_us_id\r\n" + "where user.us_id=?";

	public static final String GET_TOTAL = "select count(movie_list.mo_id) as mo_favourites from favourites\r\n"
			+ "inner join movie_list on movie_list.mo_id=favourites.fv_gr_id\r\n"
			+ "inner join user on user.us_id=favourites.fv_us_id\r\n" + "where user.us_id=?";
	
	public static final String DELETE_CART = "delete from favourites where fv_us_id=? AND fv_gr_id=? limit 1 ";

	@Override
	public void addFavouritesMovies(Integer userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIESTO_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, movieListId);
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

	@Override
	public Favourites getAllFavouritesMovies(Integer userId) throws MoviesEmptyException {
		ArrayList<MovieList> menuItemList = new ArrayList<MovieList>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MovieList menuItem = null;
		Favourites cart = new Favourites();
		try {
			preparedStatement = connection.prepareStatement(GET_CART);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MovieList();
				menuItem.setId(resultSet.getLong("mo_id"));
				menuItem.setTitle(resultSet.getString("mo_title"));
				menuItem.setBoxOffice(resultSet.getLong("mo_gross"));
				menuItem.setActive(resultSet.getString("mo_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				menuItem.setGenre(resultSet.getString("mo_genre"));
				menuItem.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				menuItemList.add(menuItem);
			}
			if (menuItemList.size() == 0) {
				throw new MoviesEmptyException();
			}
			cart.setMovieList(menuItemList);
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			int total = 0;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getInt("mo_favourites");
			}
			cart.setFavourites(total);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatementTotal != null) {
					preparedStatementTotal.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		return cart;
	}

	@Override
	public void removeFavouritesMovies(Integer userId, long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_CART);
			statement.setLong(1, userId);
			statement.setLong(2, movieListId);
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
