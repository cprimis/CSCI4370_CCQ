package com.IMDb.data;

public class Rating {
    private int rating_id;
    private String real_name;
    private String username;
    private String movie_name;
    private double user_rating;
    private String user_review;

    public Rating(int rating_id, String real_name, String username, 
            String movie_name, double user_rating, String user_review) {
        this.rating_id = rating_id;
        this.real_name = real_name;
        this.username = username;
        this.movie_name = movie_name;
        this.user_rating = user_rating;
        this.user_review = user_review;
    }
}
