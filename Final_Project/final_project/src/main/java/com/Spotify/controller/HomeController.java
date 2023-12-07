package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Spotify.data.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";
    
    @GetMapping("/")
    public ModelAndView Home() {
        ModelAndView mv = new ModelAndView("home");

        return mv;
    }
}
