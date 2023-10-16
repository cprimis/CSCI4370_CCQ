package com.IMDb.data;

public class Movie {
	private String movie_id;
	private int rank;
	private String movie_name;
	private float imdb_rating;
	private int duration;
	private String genre;
	
	public Movie(String movie_id, int rank, String movie_name, float imdb_rating, int duration, String genre) {
		this.movie_id = movie_id;
		this.rank = rank;
		this.movie_name = movie_name;
		this.imdb_rating = imdb_rating;
		this.duration = duration;
		this.genre = genre;
	} // Movie
	
}
