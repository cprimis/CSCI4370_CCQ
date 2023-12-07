package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MusicalityController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/musicality")
    public ModelAndView musicality() {
        ModelAndView mv = new ModelAndView("musicality");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String tempoQ = "SELECT Track.Track, Artist_Name, Musicality.Tempo "
                    + "  FROM Track "
                    + "  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID "
                    + "  JOIN Album ON Track.Album_ID = Album.Album_ID "
                    + "  JOIN Artist on Album.Artist_ID = Artist.Artist_ID "
                    + "  ORDER BY Musicality.Tempo DESC "
                    + "  LIMIT 10";

            ResultSet rs = stmt.executeQuery(tempoQ);

            List<Stat> tempos = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Stat tempo = new Stat(i, rs.getString("Track"), rs.getString("Artist_Name"), rs.getDouble("Tempo"));
                tempos.add(tempo);
            }
            mv.addObject("Tempos", tempos);
            
            String tempoAvgQ = "SELECT AVG(Tempo) as Mean_Tempo "
                    + "FROM Musicality";
            ResultSet rs2 = stmt.executeQuery(tempoAvgQ);
            rs2.next();
            double tempoAvg = rs2.getDouble("Mean_Tempo");
            mv.addObject("TempoAvg", tempoAvg);
            
            String keyAvgQ = "SELECT AVG(Musicality_Key) as Mean_Key "
                    + "FROM Musicality";
            ResultSet rs3 = stmt.executeQuery(keyAvgQ);
            rs3.next();
            double keyAvg = rs3.getDouble("Mean_Key");
            int keyAvgRound = (int)Math.round(keyAvg);
            
            String key = null;
            if (keyAvgRound == 0) {
                key = "C";
            } else if (keyAvgRound == 1) {
                key = "C♯/D♭";
            } else if (keyAvgRound == 2) {
                key = "D";
            } else if (keyAvgRound == 3) {
                key = "D♯/E♭";
            } else if (keyAvgRound == 4) {
                key = "E";
            } else if (keyAvgRound == 5) {
                key = "F";
            } else if (keyAvgRound == 6) {
                key = "F♯/G♭";
            } else if (keyAvgRound == 7) {
                key = "G";
            } else if (keyAvgRound == 8) {
                key = "G♯/A♭";
            } else if (keyAvgRound == 9) {
                key = "A";
            } else if (keyAvgRound == 10) {
                key = "A♯/B♭";
            } else if (keyAvgRound == 11) {
                key = "B";
            }
            
            mv.addObject("KeyAvg", keyAvg);
            mv.addObject("KeyLetter", key);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
}
