package com.cognizant.movie.Dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImplTest {
	public static void display(List<Movies> movieList) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("##,##,###");
		System.out.format("\n%5s%20s%20s%15s%20s%20s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		for (Movies movies : movieList) {
			System.out.format("\n%5s%20s%20s%15s%20s%20s%15s", movies.getId(), movies.getTitle(),
					df.format(movies.getGross()), movies.isActive(), sdf.format(movies.getDateOfLaunch()),
					movies.getgenre(), movies.isHasTeaser());
		}
	}

	public static void testGetmovieListAdmin() {
		List<Movies> movieListAdmin = new MoviesDaoSqlImpl().getMovieListAdmin();
		System.out.println("Admin");
		display(movieListAdmin);
	}

	public static void testGetmovieListCustomer() {
		List<Movies> menuItemListCustomer = new MoviesDaoSqlImpl().getMovieListCustomer();
		System.out.println("Customer");
		display(menuItemListCustomer);
	}

	public static void testModifyMovies() {
		Movies movies = new Movies(1L, "Lifted", 27879650, true, new DateUtil().convertToDate("15/03/2017"),
				"Science Fiction", true);
		new MoviesDaoSqlImpl().modifyMovies(movies);
	}

	public static void testGetmovies() {
		System.out.println("\n Enter the ID:");
		long movieListId = 1;
		Movies movie_list = new MoviesDaoSqlImpl().getMovies(movieListId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("##,##,##");
		System.out.format("\n" + "%5s%25s%15s%15s%20s%15s%15s", movie_list.getId(), movie_list.getTitle(),
				df.format(movie_list.getGross()), movie_list.isActive(), sdf.format(movie_list.getDateOfLaunch()),
				movie_list.getgenre(), movie_list.isHasTeaser());
	}

	public static void main(String[] args) {
		ConnectionHandler.getConnection();
		testGetmovieListAdmin();
		testGetmovieListCustomer();
		testModifyMovies();
		testGetmovies();
	}

}
