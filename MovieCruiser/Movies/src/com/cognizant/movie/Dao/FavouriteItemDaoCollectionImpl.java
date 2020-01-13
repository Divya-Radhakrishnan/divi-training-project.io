package com.cognizant.movie.Dao;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import com.cognizant.movie.model.Favourites;

import com.cognizant.movie.model.Movies;

public class FavouriteItemDaoCollectionImpl implements FavouriteDao {
	private static HashMap<Long, Favourites> userFavourites;

	public FavouriteItemDaoCollectionImpl() {
		super();
		if (userFavourites == null) {
			userFavourites = new HashMap<>();
		}
	}

	@Override
	public void addFavouriteMovies(long userid, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(moviesId);
		if (userFavourites.containsKey(userid)) {
			userFavourites.get(userid).getMovieList().add(movies);
		} else {
			Favourites favourites = new Favourites();
			ArrayList<Movies> movieList = new ArrayList<>();
			movieList.add(movies);
			favourites.setMovieList(movieList);
			userFavourites.put(userid, favourites);
		}
	}

	public Favourites getAllFavouriteMovies(long userId) throws FavouriteEmptyException {
		List<Movies> movieList = userFavourites.get(userId).getMovieList();
		Favourites favourites = userFavourites.get(userId);
		int total = 0;
		if (favourites == null || movieList.isEmpty()) {
			throw new FavouriteEmptyException();
		} else {
			for (Movies movies : movieList) {
				System.out.println(movies);
				total++;
			}
		}
		favourites.setTotal(total);
		return favourites;
	}

	@Override
	public void removeFavouriteMovies(long userId, long MoviesId) {
		List<Movies> movieList = userFavourites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == MoviesId) {
				movieList.remove(i);
				return;
			}
		}

	}
}
