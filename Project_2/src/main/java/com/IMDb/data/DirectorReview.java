package com.IMDb.data;

public class DirectorReview {
	
	private String director_name;
	private String movie_name;
	private float user_rating;
	private String user_review;
	
	public DirectorReview(String director_name, String movie_name, float user_rating, String user_review) {
		this.director_name = director_name;
		this.movie_name = movie_name;
		this.user_rating = user_rating;
		this.user_review = user_review;
	} // ActorReview
	
	public String toString() {
		return "Director name: " + director_name+ "\n"
			+ "Movie name: " + movie_name + "\n"
			+ "User Rating: " + user_rating + "\n"
			+ "User Review: " + user_review + "\n";
	} // toString

} // ActorReview
