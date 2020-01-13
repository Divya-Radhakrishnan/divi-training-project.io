
package com.cognizant.movie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String GET_ALL_MOVIELIST_ADMIN = "SELECT * FROM movie_list";

	public List<Movies> getMovieListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIELIST_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setgenre(resultSet.getString("mo_gener"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	public static final String GET_ALL_MOVIE_CUSTOMER = "select*from movie_list where movie_list.mo_date_of_launch>curdate() and mo_active='Yes';";

	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIE_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setgenre(resultSet.getString("mo_gener"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	public static final String EDIT_MOVIE_LIST = "update movie_list set mo_title=?,mo_gross=?,mo_active=?,mo_date_of_launch=?,mo_gener=?,mo_has_teaser=? where mo_id=?";

	public void modifyMovies(Movies movies) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(EDIT_MOVIE_LIST);
			statement.setString(1, movies.getTitle());
			statement.setFloat(2, movies.getGross());
			statement.setString(3, movies.isActive() ? "Yes" : "No");
			statement.setDate(4, new DateUtil().convertToSqlDate(movies.getDateOfLaunch()));
			statement.setString(5, movies.getgenre());
			statement.setString(6, movies.isHasTeaser() ? "Yes" : "No");
			statement.setLong(7, movies.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update not done");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}

	}

	public static final String GET_MOVIELIST = "select*from movie_list where mo_id=?";

	public Movies getMovies(Long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Movies movie_list = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MOVIELIST);
			preparedstatement.setLong(1, moviesId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				movie_list = new Movies();
				movie_list.setId(resultset.getLong("mo_id"));
				movie_list.setTitle(resultset.getString("mo_title"));
				movie_list.setGross(resultset.getLong("mo_gross"));
				movie_list.setActive(resultset.getString("mo_active").equals("Yes"));
				movie_list.setDateOfLaunch(resultset.getDate("mo_date_of_launch"));
				movie_list.setgenre(resultset.getString("mo_gener"));
				movie_list.setHasTeaser(resultset.getString("mo_has_teaser").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
		return movie_list;
	}
}
