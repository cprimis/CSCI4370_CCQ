package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";
    
    @GetMapping("/login")
    public ModelAndView leaderboard() {
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }
    
    @PostMapping("/submitlogin")
    public ModelAndView formsubmit(String username, String pw, HttpServletResponse response) {
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
            
            String pwQuery = "SELECT pw FROM users where username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(pwQuery);

            rs.next();
            String ret_pw = rs.getString("pw");
            if(ret_pw.equals(pw)) {
            	System.out.println("User is real!");
            	Cookie username_cookie = new Cookie("username", username);
            	response.addCookie(username_cookie);
            } // if
                        
            
   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        
        return new ModelAndView("redirect:/");
    }
}
