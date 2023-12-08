package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RandomController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/random")
    public ModelAndView random(HttpServletRequest request) {
        if(LoginController.isLoggedIn(request) == false) {
        	System.out.println("User is not logged in");
        	return new ModelAndView("login");
        } // if
        ModelAndView mv = new ModelAndView("random");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String getIDs = "SELECT Track.Track_ID " + "FROM Track "
                    + "JOIN Spotify_YouTube ON Track.Track_ID = Spotify_YouTube.Track_ID "
                    + "JOIN YouTube_Video ON Spotify_YouTube.YouTube_ID = YouTube_Video.YouTube_ID "
                    + "JOIN Performance ON YouTube_Video.YouTube_Video_ID = Performance.YouTube_Video_ID "
                    + "WHERE YouTube_Video.URL_YouTube IS NOT NULL";

            ResultSet rs = stmt.executeQuery(getIDs);

            List<Integer> IDs = new ArrayList<>();
            while (rs.next()) {
                IDs.add(rs.getInt("Track_ID"));
            }

            Random randomizer = new Random();
            int ID = IDs.get(randomizer.nextInt(IDs.size())).intValue();

            String query = "SELECT Track.Track, Artist.Artist_Name, YouTube_Video.Title, YouTube_Video.Channel, YouTube_Video.Licensed, YouTube_Video.Official_Video, YouTube_Video.URL_YouTube, Performance.Likes, Performance.Comments "
                    + "FROM Track " + "JOIN Spotify_YouTube ON Track.Track_ID = Spotify_YouTube.Track_ID "
                    + "JOIN YouTube_Video ON Spotify_YouTube.YouTube_ID = YouTube_Video.YouTube_ID "
                    + "JOIN Performance ON YouTube_Video.YouTube_Video_ID = Performance.YouTube_Video_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist ON Album.Artist_ID = Artist.Artist_ID " + "WHERE Track.Track_ID = " + ID;

            ResultSet rs2 = stmt.executeQuery(query);
            rs2.next();

            String isLicensed;
            String isOfficial;
            if (rs2.getBoolean("Licensed")) {
                isLicensed = "licensed";
            } else {
                isLicensed = "not licensed";
            }

            if (rs2.getBoolean("Official_Video")) {
                isOfficial = "official";
            } else {
                isOfficial = "not official";
            }

            Video randomSong = new Video(rs2.getString("Track"), rs2.getString("Artist_Name"), rs2.getString("Title"),
                    rs2.getString("Channel"), isLicensed, isOfficial,
                    "https://www.youtube.com/embed/" + rs2.getString("URL_YouTube"), rs2.getInt("Likes"),
                    rs2.getInt("Comments"));

            mv.addObject("RandomSong", randomSong);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
}
