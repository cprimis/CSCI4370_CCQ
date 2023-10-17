package com.IMDb.controller;

import com.IMDb.data.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeleteController {
    String url = "jdbc:mysql://localhost:33306/Project_2";
    String user = "root";
    String password = "mysqlpass";
    
    @GetMapping("/delete")
    public ModelAndView delete() {
        ModelAndView mv = new ModelAndView("delete");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM Ratings ORDER BY rating_id DESC";
            String movie_query = "SELECT * FROM Movie";            
            ResultSet rs = stmt.executeQuery(query);
            List<Rating> ratings = new ArrayList<>();            
            while (rs.next()) {
                Rating rating = new Rating(rs.getInt("rating_id"), rs.getString("real_name"), rs.getString("username"), 
                        rs.getString("movie_name"), rs.getDouble("user_rating"), rs.getString("user_review"));
                ratings.add(rating);
                
            } // while            
            ResultSet movie_rs = stmt.executeQuery(movie_query);
            List<Movie> movies = new ArrayList<>();
            while (movie_rs.next()) {
                Movie movie = new Movie(movie_rs.getInt("rank"), movie_rs.getString("movie_name"), movie_rs.getString("release_year"), 
                		movie_rs.getFloat("imdb_rating"), movie_rs.getInt("duration"), movie_rs.getString("genre"));
                movies.add(movie);
            } // while
            
            mv.addObject("ratings", ratings);
            mv.addObject("movies", movies);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
    
    @PostMapping("/submitdelete")
    public ModelAndView formsubmit(int rating_id) {
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
                        
            String del = "DELETE FROM Ratings WHERE rating_id = " + rating_id;
            stmt.executeUpdate(del);
   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        
        return new ModelAndView("redirect:/delete");
    }
}
