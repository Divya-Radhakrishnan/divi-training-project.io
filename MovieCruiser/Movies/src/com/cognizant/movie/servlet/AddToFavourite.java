package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.Dao.FavouriteDaoSqlImpl;
import com.cognizant.movie.Dao.MoviesDao;
import com.cognizant.movie.Dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;

/**
 * Servlet implementation class AddToFavouriteServlet
 */
@WebServlet("/AddToFavourite")
public class AddToFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavourite() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long userId = 1l;
		Long movieId = Long.parseLong(request.getParameter("id"));
		FavouriteDaoSqlImpl favouriteDao = new FavouriteDaoSqlImpl();

		favouriteDao.addFavouriteMovies(userId, movieId);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		request.setAttribute("movies", movieList);
		request.setAttribute("addFavouriteStatus", true);
		request.getRequestDispatcher("edit-movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
