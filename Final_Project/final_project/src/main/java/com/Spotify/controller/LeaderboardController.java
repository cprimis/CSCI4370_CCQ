package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LeaderboardController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/leaderboard")
    public ModelAndView leaderboard(HttpServletRequest request) {
        if(LoginController.isLoggedIn(request) == false) {
        	System.out.println("User is not logged in");
        	return new ModelAndView("login");
        } // if
        ModelAndView mv = new ModelAndView("leaderboard");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String query = "SELECT Album.Album_Name, Artist.Artist_Name, COUNT(Track.Track_ID) AS TrackCount " 
                    + "FROM Album "
                    + "LEFT JOIN Track ON Album.Album_ID = Track.Album_ID "
                    + "JOIN Artist ON Album.Artist_ID = Artist.Artist_ID "
                    + "GROUP BY Album.Album_ID, Album.Album_Name, Artist.Artist_Name " 
                    + "ORDER BY TrackCount DESC LIMIT 50";
            ResultSet rs = stmt.executeQuery(query);

            List<Leader> leaders = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Leader leader = new Leader(i, rs.getString("Album_Name"), rs.getString("Artist_Name"),rs.getInt("TrackCount"));
                leaders.add(leader);
            }

            mv.addObject("leaders", leaders);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
}
