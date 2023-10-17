package com.IMDb.controller;

import com.IMDb.data.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LeaderboardController {
    String url = "jdbc:mysql://localhost:33306/Project_2";
    String user = "root";
    String password = "mysqlpass";

    @GetMapping("/leaderboard")
    public ModelAndView leaderboard() {
        ModelAndView mv = new ModelAndView("leaderboard");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmt = connection.createStatement();
            String query = "SELECT username, COUNT(*) AS \"review_count\" FROM Ratings "
                    + "GROUP BY username ORDER BY COUNT(*) DESC LIMIT 10";
            ResultSet rs = stmt.executeQuery(query);

            List<Leader> leaders = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i += 1;
                Leader leader = new Leader(i, rs.getString("username"), rs.getInt("review_count"));
                leaders.add(leader);
            }

            mv.addObject("leaders", leaders);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }

        return mv;
    }
}
