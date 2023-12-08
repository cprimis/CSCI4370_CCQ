package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import java.sql.*;
import org.springframework.ui.Model;

@RestController
public class WebController {

    String url = "jdbc:mysql://localhost:33306/Spotify";
    String username = "root";
    String password = "mysqlpass";
    
    public WebController() {
        //System.out.println("Connecting database...");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }    
}
