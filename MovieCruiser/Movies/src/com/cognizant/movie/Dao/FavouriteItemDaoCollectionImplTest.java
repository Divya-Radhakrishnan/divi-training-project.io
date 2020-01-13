package com.cognizant.movie.Dao;

import com.cognizant.movie.model.Favourites;
import com.cognizant.movie.model.Movies;

public class FavouriteItemDaoCollectionImplTest {
	public static void testAddFavouriteMovies() throws FavouriteEmptyException {

		FavouriteDao favouriteDao = new FavouriteItemDaoCollectionImpl();
		favouriteDao.addFavouriteMovies(1, 2L);
		favouriteDao.addFavouriteMovies(1, 5L);
		favouriteDao.addFavouriteMovies(2, 1L);
		favouriteDao.addFavouriteMovies(2, 3L);
		Favourites movieListCustomer = favouriteDao.getAllFavouriteMovies(1);
		// System.out.println("User Added Favourite List for Checkout");
		for (Movies movies : movieListCustomer.getMovieList()) {
			System.out.println(movies);

		}
	}

	public static void testRemovefavouriteMovies() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteItemDaoCollectionImpl();
		// System.out.println("List for Customer after Remove");
		try {
			favouriteDao.removeFavouriteMovies(1, 2l);
			favouriteDao.removeFavouriteMovies(1, 5L);
			favouriteDao.removeFavouriteMovies(1, 3l);
			Favourites movieListCustomer = favouriteDao.getAllFavouriteMovies(1);
			int count = 0;
			int total = 0;
			for (Movies movies : movieListCustomer.getMovieList()) {
				System.out.println(movies);
				total += movies.getGross();
				count++;
			}
			System.out.println("total Favourites = " + count);
			System.out.println("total Gross = " + total);
		} catch (FavouriteEmptyException e) {
			// System.out.println(e.getMessage());
		}
	}

	public static void testGetAllfavouriteMovies() {

	}

	public static void main(String[] args) throws FavouriteEmptyException {
		testAddFavouriteMovies();
		testRemovefavouriteMovies();
	}

}
