package com.IMDb.data;

public class ActorReview {
	
	private String cast_name;
	private String movie_name;
	private float user_rating;
	private String user_review;
	
	public ActorReview(String cast_name, String movie_name, float user_rating, String user_review) {
		this.cast_name = cast_name;
		this.movie_name = movie_name;
		this.user_rating = user_rating;
		this.user_review = user_review;
	} // ActorReview
	
	public String toString() {
		return "Actor name: " + cast_name+ "\n"
			+ "Movie name: " + movie_name + "\n"
			+ "User Rating: " + user_rating + "\n"
			+ "User Review: " + user_review + "\n";
		
	}

} // ActorReview
