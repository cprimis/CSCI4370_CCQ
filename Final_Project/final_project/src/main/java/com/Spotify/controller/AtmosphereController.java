package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.Spotify.data.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmosphereController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/atmosphere")
    public ModelAndView atmosphere(HttpServletRequest request) {
        if(LoginController.isLoggedIn(request) == false) {
        	System.out.println("User is not logged in");
        	return new ModelAndView("login");
        } // if
        ModelAndView mv = new ModelAndView("atmosphere");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
            String valenceQ = "SELECT Track.Track, Artist_Name, Human_Connection.Valence " 
                    + "FROM Track "
                    + "JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID " 
                    + "ORDER BY Human_Connection.Valence DESC "
                    + "LIMIT 10";
            
            ResultSet rs = stmt.executeQuery(valenceQ);
            
            List<Stat> valences = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Stat valence = new Stat(i, rs.getString("Track"), rs.getString("Artist_Name"), rs.getDouble("Valence"));
                valences.add(valence);
            }
            mv.addObject("Valences", valences);
            
            String valenceAvgQ = "SELECT AVG(Valence) as Mean_Valence " + "FROM Human_Connection";
            ResultSet rs2 = stmt.executeQuery(valenceAvgQ);
            rs2.next();
            double valenceAvg = rs2.getDouble("Mean_Valence");
            mv.addObject("ValenceAvg", valenceAvg);
            
            String livenessQ = "SELECT Track.Track, Artist_Name, Human_Connection.Liveness " 
                    + "FROM Track "
                    + "JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID " 
                    + "ORDER BY Human_Connection.Liveness DESC "
                    + "LIMIT 10";
            ResultSet rs3 = stmt.executeQuery(livenessQ);
            List<Stat> livenesses = new ArrayList<>();
            i = 0;
            while (rs3.next()) {
                i += 1;
                Stat liveness = new Stat(i, rs3.getString("Track"), rs3.getString("Artist_Name"),
                        rs3.getDouble("Liveness"));
                livenesses.add(liveness);
            }
            mv.addObject("Livenesses", livenesses);
            
            String livenessAvgQ = "SELECT AVG(Liveness) as Mean_Liveness " + "FROM Human_Connection";
            ResultSet rs4 = stmt.executeQuery(livenessAvgQ);
            rs4.next();
            double livenessAvg = rs4.getDouble("Mean_Liveness");
            mv.addObject("LivenessAvg", livenessAvg);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        return mv;
    }
}
