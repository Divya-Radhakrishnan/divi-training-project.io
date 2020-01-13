package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.Dao.MoviesDao;
import com.cognizant.movie.Dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;

/**
 * Servlet implementation class ShowMovieListServlet
 */
@WebServlet("/ShowEditMovieList")
public class ShowEditMovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieList() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		Long movieId = Long.parseLong(request.getParameter("id"));
		Movies movie = moviesDao.getMovies(movieId);
		request.setAttribute("movies", movie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movie-list.jsp");
		dispatcher.forward(request, response);
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
