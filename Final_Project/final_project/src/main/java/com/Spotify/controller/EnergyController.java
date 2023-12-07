package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EnergyController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/energy")
    public ModelAndView energy() {
        ModelAndView mv = new ModelAndView("energy");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String energyQ = "SELECT Track.Track, Artist_Name, Energy.Energy " 
                    + "FROM Track "
                    + "JOIN Energy ON Track.Track_ID = Energy.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID " 
                    + "ORDER BY Energy.Energy DESC "
                    + "LIMIT 10";

            ResultSet rs = stmt.executeQuery(energyQ);

            List<Stat> energies = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Stat energy = new Stat(i, rs.getString("Track"), rs.getString("Artist_Name"), rs.getDouble("Energy"));
                energies.add(energy);
            }
            mv.addObject("Energies", energies);

            String energyAvgQ = "SELECT AVG(Energy) as Mean_Energy " 
                    + "FROM Energy";
            ResultSet rs2 = stmt.executeQuery(energyAvgQ);
            rs2.next();
            double energyAvg = rs2.getDouble("Mean_Energy");
            mv.addObject("EnergyAvg", energyAvg);

            String danceabilityQ = "SELECT Track.Track, Artist_Name, Energy.Danceability " 
                    + "FROM Track "
                    + "JOIN Energy ON Track.Track_ID = Energy.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID " 
                    + "ORDER BY Energy.Danceability DESC "
                    + "LIMIT 10";
            ResultSet rs3 = stmt.executeQuery(danceabilityQ);
            List<Stat> danceabilities = new ArrayList<>();
            i = 0;
            while (rs3.next()) {
                i += 1;
                Stat danceability = new Stat(i, rs3.getString("Track"), rs3.getString("Artist_Name"),
                        rs3.getDouble("Danceability"));
                danceabilities.add(danceability);
            }
            mv.addObject("Danceabilities", danceabilities);
            
            String danceabilityAvgQ = "SELECT AVG(Danceability) as Mean_Danceability " 
                    + "FROM Energy";
            ResultSet rs4 = stmt.executeQuery(danceabilityAvgQ);
            rs4.next();
            double danceabilityAvg = rs4.getDouble("Mean_Danceability");
            mv.addObject("DanceabilityAvg", danceabilityAvg);

            String energyDanceabilityQ = "SELECT Track.Track, Artist_Name, (Energy + Danceability) / 2 AS Energy_Danceability "
                    + "FROM Track "
                    + "JOIN Energy ON Track.Track_ID = Energy.Track_ID "
                    + "JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "ORDER BY Energy_Danceability DESC "
                    + "LIMIT 10";
            ResultSet rs5 = stmt.executeQuery(energyDanceabilityQ);
            List<Stat> energiesdanceabilities = new ArrayList<>();
            i = 0;
            while (rs5.next()) {
                i += 1;
                Stat energydanceability = new Stat(i, rs5.getString("Track"), rs5.getString("Artist_Name"),
                        rs5.getDouble("Energy_Danceability"));
                energiesdanceabilities.add(energydanceability);
            }
            mv.addObject("Energy_Danceability", energiesdanceabilities);
            
            String energyDanceabilityAvgQ = "SELECT AVG((Energy + Danceability) / 2) as Mean_Energy_Danceability\r\n"
                    + "  FROM Track JOIN Energy ON Track.Track_ID = Energy.Track_ID";
            ResultSet rs6 = stmt.executeQuery(energyDanceabilityAvgQ);
            rs6.next();
            double energyDanceabilityAvg = rs6.getDouble("Mean_Energy_Danceability");
            mv.addObject("EnergyDanceabilityAvg", energyDanceabilityAvg);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
}
