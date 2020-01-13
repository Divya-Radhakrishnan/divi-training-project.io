package com.cognizant.movie.Dao;

import com.cognizant.movie.model.Favourites;

public interface FavouriteDao {
	public void addFavouriteMovies(long userId, long moviesId);

	public Favourites getAllFavouriteMovies(long userId) throws FavouriteEmptyException;

	public void removeFavouriteMovies(long userId, long MenuItemId);

}
