package com.cognizant.movie.Dao;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import com.cognizant.movie.model.Movies;

import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		super();
		if (movieList == null) {

			movieList = new ArrayList<Movies>();

			Movies ListOne = new Movies(1L, "Avatar", 278796508, true, new DateUtil().convertToDate("15/03/2017"),
					"ScienceFiction", true);
			Movies ListTwo = new Movies(2L, "The Avengers", 151881298, true, new DateUtil().convertToDate("23/12/2017"),
					"Superhero", false);
			Movies ListThree = new Movies(3L, "Titanic", 21874639, true, new DateUtil().convertToDate("21/08/2020"),
					"Romantic", false);
			Movies ListFour = new Movies(4L, "Jurassic World", 16717132, false,
					new DateUtil().convertToDate("12/12/2019"), "ScienceFiction", true);
			Movies ListFive = new Movies(5L, "Avengers: End Game", 27507603, true,
					new DateUtil().convertToDate("02/11/2022"), "Superhero", true);
			movieList.add(ListOne);
			movieList.add(ListTwo);
			movieList.add(ListThree);
			movieList.add(ListFour);
			movieList.add(ListFive);
		}
	}

	@Override
	public List<Movies> getMovieListAdmin() {
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().before(new Date())) {
				if (movies.isActive()) {
					filteredMovies.add(movies);
				}
			}
		}
		return filteredMovies;
	}

	@Override
	public void modifyMovies(Movies movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getMovies(Long moviesId) {
		for (Movies movie : movieList) {
			if (movie.getId() == moviesId) {
				return movie;
			}
		}
		return null;
	}
}
