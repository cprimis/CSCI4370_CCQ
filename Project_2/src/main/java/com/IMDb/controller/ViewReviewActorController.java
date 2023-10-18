package com.IMDb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.IMDb.data.Actor;
import com.IMDb.data.ActorReview;
import com.IMDb.data.Movie;
import com.IMDb.data.Rating;

@RestController
public class ViewReviewActorController {
    String url = "jdbc:mysql://localhost:33306/Project_2";
    String user = "root";
    String password = "mysqlpass";
    List<ActorReview> object_actor_review = null;
	
    @GetMapping("/view_reviews_actor")
    public ModelAndView leaderboard() {
    	ModelAndView mv = new ModelAndView("actor_review");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            
            
            String query = "SELECT * FROM Ratings ORDER BY rating_id DESC";
            ResultSet rs = stmt.executeQuery(query);
            List<Rating> ratings = new ArrayList<>();            
            while (rs.next()) {
                Rating rating = new Rating(rs.getInt("rating_id"), rs.getString("real_name"), rs.getString("username"), 
                        rs.getString("movie_name"), rs.getDouble("user_rating"), rs.getString("user_review"));
                ratings.add(rating);
                
            } // while

            String movie_query = "SELECT * FROM Movie";            
            ResultSet movie_rs = stmt.executeQuery(movie_query);
            List<Movie> movies = new ArrayList<>();
            while (movie_rs.next()) {
                Movie movie = new Movie(movie_rs.getInt("rank"), movie_rs.getString("movie_name"), movie_rs.getString("release_year"), 
                		movie_rs.getFloat("imdb_rating"), movie_rs.getInt("duration"), movie_rs.getString("genre"));
                movies.add(movie);
            } // while
            
            String actor_query = "SELECT * FROM Actors ORDER BY cast_name"; 
            ResultSet actor_rs = stmt.executeQuery(actor_query);
            List<Actor> actors = new ArrayList<>();
            while (actor_rs.next()) {
                Actor actor = new Actor(actor_rs.getString("cast_id"), actor_rs.getString("cast_name"));
                actors.add(actor);
            } // while
            

            mv.addObject("ratings", ratings);
            mv.addObject("movies", movies);
            mv.addObject("actors", actors);
            mv.addObject("actor_review",object_actor_review);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }

    @PostMapping("/submitactorreview")
    public ModelAndView formsubmit(String cast_name) {
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String query_for_actor = String.format("SELECT cast_name,movie_name,user_rating, user_review FROM Ratings "
            		+ "Natural JOIN Movie "
            		+ "NATURAL JOIN Movie_Actors "
            		+ "NATURAL JOIN Actors "
            		+ "WHERE cast_name = '" + cast_name + "';");            
            
            ResultSet rs = stmt.executeQuery(query_for_actor);

            List<ActorReview> actor_reviews = new ArrayList<>();   
            while (rs.next()) {
                ActorReview actor_review = new ActorReview(rs.getString("cast_name"),
                			rs.getString("movie_name"),rs.getFloat("user_rating"),rs.getString("user_review"));
                actor_reviews.add(actor_review);
            } // while
            this.object_actor_review = actor_reviews;
   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        return new ModelAndView("redirect:/view_reviews_actor");
    } // formsubmit

}
