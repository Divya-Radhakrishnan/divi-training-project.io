package com.cognizant.movie.Dao;

public class FavouriteEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	public FavouriteEmptyException() {
		super("favourite list is Empty");
	}

}
