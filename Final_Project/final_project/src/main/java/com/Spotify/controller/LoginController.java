package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class LoginController {
    String url = "jdbc:mysql://localhost:33306/Spotify";
    String user = "root";
    String password = "mysqlpass";
    
    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("login");

//        System.out.println(readAllCookies(request));
        
        return mv;
    }
    
    @PostMapping("/submitlogin")
    public ModelAndView formsubmit(String username, String pw, HttpServletResponse response) {
    	
    	ZonedDateTime zdt = ZonedDateTime.now(ZoneId.systemDefault())
                .minusDays(1)
                .with(LocalTime.of(19, 0));

    	Timestamp timestamp = new Timestamp(zdt.toInstant().toEpochMilli());

        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
            
            String pwQuery = "SELECT password FROM user_login where username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(pwQuery);
            if(rs.next() == true) {
            	String ret_pw = rs.getString(1);
            	if(ret_pw.equals(pw)) {
        	    	ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.systemDefault());
        	
        	    	Timestamp timestamp1 = new Timestamp(zdt1.toInstant().toEpochMilli());
            		String updateQuery = "UPDATE user_login\r\n"
            				+ "SET last_login = '" + timestamp1 + "'"
            				+ "WHERE username = '" + username + "' AND password = '" + pw + "'";
                    stmt.execute(updateQuery);

            		Cookie username_cookie = new Cookie("username", username);
            		username_cookie.setMaxAge(300);
            		username_cookie.setSecure(true);
            		username_cookie.setPath("");
            		response.addCookie(username_cookie);
            	} // if
            } // if
            
   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        
        return new ModelAndView("redirect:/");
    }
    
    public static boolean isLoggedIn(HttpServletRequest request) {
    	boolean isLoggedIn = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {

        		if(cookie.getName().equals("username")) {

        			isLoggedIn = true;
            	} // if
            } // for
        } // if
        return isLoggedIn;
    }
    
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("register");
        
        return mv;
    }
    @PostMapping("/submitregister")
    public ModelAndView submitregister(String username, String pw, HttpServletResponse response) {
    	try {
	        Connection connection = DriverManager.getConnection(url, user, password);
	        
	        Statement stmt = connection.createStatement();
	    	ZonedDateTime zdt = ZonedDateTime.now(ZoneId.systemDefault());
	
	    	Timestamp timestamp = new Timestamp(zdt.toInstant().toEpochMilli());

			String userIns = "INSERT INTO user_login VALUES"
					+ "( '" + username
					+ "', '" + pw
					+ "', '" + timestamp.toString()
					+ "')";
            stmt.execute(userIns);
            } catch(Exception e) {
    		System.out.println(e);
    	} // try
		
		
		return new ModelAndView("redirect:/login");
    }
}
