package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.Spotify.data.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class VolumeController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";


    @GetMapping("/volume")
    public ModelAndView volume(HttpServletRequest request) {


        ModelAndView mv = new ModelAndView("volume");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
            String loudnessQ = "SELECT Track.Track, Artist_Name, Spoken_Volume.Loudness "
                    + "FROM Track "
                    + "JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Spoken_Volume.Loudness DESC "
                    + "LIMIT 10";
            
            ResultSet rs = stmt.executeQuery(loudnessQ);
            
            List<Stat> loudnesses = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Stat loudness = new Stat(i, rs.getString("Track"), rs.getString("Artist_Name"), rs.getDouble("Loudness"));
                loudnesses.add(loudness);
            }
            mv.addObject("Loudnesses", loudnesses);
            
            String loudnessAvgQ = "SELECT AVG(Loudness) as Mean_Loudness " + "FROM Spoken_Volume";
            ResultSet rs2 = stmt.executeQuery(loudnessAvgQ);
            rs2.next();
            double loudnessAvg = rs2.getDouble("Mean_Loudness");
            mv.addObject("LoudnessAvg", loudnessAvg);
            
            String instrumentalnessQ = "SELECT Track.Track, Artist_Name, Spoken_Volume.Instrumentalness "
                    + "FROM Track "
                    + "JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Spoken_Volume.Instrumentalness DESC "
                    + "LIMIT 10";
            ResultSet rs3 = stmt.executeQuery(instrumentalnessQ);
            List<Stat> instrumentalnesses = new ArrayList<>();
            i = 0;
            while (rs3.next()) {
                i += 1;
                Stat instrumentalness = new Stat(i, rs3.getString("Track"), rs3.getString("Artist_Name"),
                        rs3.getDouble("Instrumentalness"));
                instrumentalnesses.add(instrumentalness);
            }
            mv.addObject("Instrumentalnesses", instrumentalnesses);
            
            String instrumentalnessAvgQ = "SELECT AVG(Instrumentalness) as Mean_Instrumentalness " + "FROM Spoken_Volume";
            ResultSet rs4 = stmt.executeQuery(instrumentalnessAvgQ);
            rs4.next();
            double instrumentalnessAvg = rs4.getDouble("Mean_Instrumentalness");
            mv.addObject("InstrumentalnessAvg", instrumentalnessAvg);
                       
            String speechinessQ = "SELECT Track.Track, Artist_Name, Spoken_Volume.Speechiness "
                    + "FROM Track "
                    + "JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Spoken_Volume.Speechiness DESC "
                    + "LIMIT 10";
            ResultSet rs5 = stmt.executeQuery(speechinessQ);
            List<Stat> speechinesses = new ArrayList<>();
            i = 0;
            while (rs5.next()) {
                i += 1;
                Stat speechiness = new Stat(i, rs5.getString("Track"), rs5.getString("Artist_Name"), rs5.getDouble("Speechiness"));
                speechinesses.add(speechiness);
            }
            mv.addObject("Speechinesses", speechinesses);
            
            String speechinessAvgQ = "SELECT AVG(Speechiness) as Mean_Speechiness " + "FROM Spoken_Volume";
            ResultSet rs6 = stmt.executeQuery(speechinessAvgQ);
            rs6.next();
            double speechinessAvg = rs6.getDouble("Mean_Speechiness");
            mv.addObject("SpeechinessAvg", speechinessAvg);
           
            String AcousticnessQ = "SELECT Track.Track, Artist_Name, Spoken_Volume.Acousticness "
                    + "FROM Track "
                    + "JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Spoken_Volume.Acousticness DESC "
                    + "LIMIT 10";
            ResultSet rs7 = stmt.executeQuery(AcousticnessQ);
            List<Stat> Acousticnesses = new ArrayList<>();
            i = 0;
            while (rs7.next()) {
                i += 1;
                Stat Acousticness = new Stat(i, rs7.getString("Track"), rs7.getString("Artist_Name"),
                        rs7.getDouble("Acousticness"));
                Acousticnesses.add(Acousticness);
            }
            mv.addObject("Acousticnesses", Acousticnesses);
           
            String AcousticnessAvgQ = "SELECT AVG(Acousticness) as Mean_Acousticness " + "FROM Spoken_Volume";
            ResultSet rs8 = stmt.executeQuery(AcousticnessAvgQ);
            rs8.next();
            double AcousticnessAvg = rs8.getDouble("Mean_Acousticness");
            mv.addObject("AcousticnessAvg", AcousticnessAvg);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        return mv;
    }
}





