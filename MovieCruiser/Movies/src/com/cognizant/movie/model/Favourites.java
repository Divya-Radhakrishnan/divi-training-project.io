package com.cognizant.movie.model;

import java.util.*;

public class Favourites {
	private List<Movies> movieList;
	private int total;

	public Favourites() {
		super();
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total2) {
		this.total = total2;
	}

	@Override
	public String toString() {
		return "Favourites [movieList=" + movieList + ", total=" + total + "]";
	}

}
