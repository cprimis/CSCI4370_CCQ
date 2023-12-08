package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";
    
    @GetMapping("/")
    public ModelAndView Home(HttpServletRequest request) {
        if(LoginController.isLoggedIn(request) == false) {
        	System.out.println("User is not logged in");
        	return new ModelAndView("login");
        } // if
        ModelAndView mv = new ModelAndView("home");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String songsQ = "SELECT Track.Track, Artist_Name, Album_Name, Musicality.Tempo, Musicality.Musicality_Key, "
                    + "Energy.Energy, Energy.Danceability, Human_Connection.Valence, Human_Connection.Liveness, "
                    + "Spoken_Volume.Loudness, Spoken_Volume.Instrumentalness, Spoken_Volume.Speechiness, Spoken_Volume.Acousticness "
                    + "FROM Track "
                    + "JOIN Musicality ON Track.Track_ID = Musicality.Track_ID "
                    + "JOIN Energy ON Track.Track_ID = Energy.Track_ID "
                    + "JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID "
                    + "JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Track.Track";

            ResultSet rs = stmt.executeQuery(songsQ);

            List<AllStats> songs = new ArrayList<>();
            while (rs.next()) {
                double keyNum = rs.getDouble("Musicality_Key");
                String key = null;
                if (keyNum == 0) {
                    key = "C";
                } else if (keyNum == 1) {
                    key = "C♯/D♭";
                } else if (keyNum == 2) {
                    key = "D";
                } else if (keyNum == 3) {
                    key = "D♯/E♭";
                } else if (keyNum == 4) {
                    key = "E";
                } else if (keyNum == 5) {
                    key = "F";
                } else if (keyNum == 6) {
                    key = "F♯/G♭";
                } else if (keyNum == 7) {
                    key = "G";
                } else if (keyNum == 8) {
                    key = "G♯/A♭";
                } else if (keyNum == 9) {
                    key = "A";
                } else if (keyNum == 10) {
                    key = "A♯/B♭";
                } else if (keyNum == 11) {
                    key = "B";
                }
                
                AllStats song = new AllStats(rs.getString("Track"), rs.getString("Artist_Name"),
                        rs.getString("Album_Name"), rs.getDouble("Tempo"), key,
                        rs.getDouble("Energy"), rs.getDouble("Danceability"), rs.getDouble("Valence"),
                        rs.getDouble("Liveness"), rs.getDouble("Loudness"), rs.getDouble("Instrumentalness"),
                        rs.getDouble("Speechiness"), rs.getDouble("Acousticness"));
                songs.add(song);
            }
            mv.addObject("Songs", songs);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        
        return mv;
    }
}
