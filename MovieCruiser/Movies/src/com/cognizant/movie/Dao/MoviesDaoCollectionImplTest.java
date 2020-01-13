package com.cognizant.movie.Dao;

import java.util.List;
import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImplTest {
	public static void testGetmovielistAdmin() {
		System.out.println("List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
			// System.out.println(new
			// DateUtil().convertToString(movies.getDateOfLaunch()));
		}
	}

	public static void testGetMovieListCustomer() {
		// System.out.println("List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}

	}

	public static void testModifyMovies() {
		Movies List = new Movies(5L, "Avengers", 27507699, false, new DateUtil().convertToDate("02/11/2022"),
				"Super Hero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(List);
		System.out.println("Modify List****");
		testGetmovielistAdmin();
		Movies modified_List = moviesDao.getMovies(List.getId());
		System.out.println("Modified List Detail\n" + modified_List);

	}

	public static void main(String[] args) {
		testGetmovielistAdmin();
		testGetMovieListCustomer();
		testModifyMovies();
	}
}
