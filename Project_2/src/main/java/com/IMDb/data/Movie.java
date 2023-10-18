package com.IMDb.data;

public class Movie {
	
	private int rank;
	private String movie_name;	
	private String release_year;
	private float imdb_rating;
	private int duration;
	private String genre;
	
	public Movie(int rank, String movie_name, String release_year,
			float imdb_rating, int duration, String genre) {
		this.rank = rank;
		this.movie_name = movie_name;		
		this.release_year = release_year;
		this.imdb_rating = imdb_rating;
		this.duration = duration;
		this.genre = genre;
	} // Movie

} // Movie
