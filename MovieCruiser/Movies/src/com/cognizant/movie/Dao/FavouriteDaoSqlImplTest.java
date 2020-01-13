package com.cognizant.movie.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import com.cognizant.movie.model.Favourites;

public class FavouriteDaoSqlImplTest {
	public static void testaddFavouriteMovies() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to Add");
		long menuItemId = Long.parseLong(bf.readLine());
		new FavouriteDaoSqlImpl().addFavouriteMovies(userId, menuItemId);
	}

	public static void testremoveFavouriteMovies() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to remove");
		long MoviesId = Long.parseLong(bf.readLine());
		new FavouriteDaoSqlImpl().removeFavouriteMovies(userId, MoviesId);
	}

	public static void testgetAllFavouriteMovies() throws FavouriteEmptyException, SQLException {
		long userId = 2;
		Favourites favourite = new FavouriteDaoSqlImpl().getAllFavouriteMovies(userId);
		System.out.println(favourite.getMovieList());
		// System.out.println("Total=" + favourite.getTotal());
	}

	public static void main(String[] args) throws IOException, ParseException, FavouriteEmptyException, SQLException {
		testaddFavouriteMovies();
		testremoveFavouriteMovies();
		testgetAllFavouriteMovies();

	}

}
