package com.IMDb.data;

import java.sql.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class test_sql {

	public static void main(String[] args) {
	    String url = "jdbc:mysql://localhost:33306/project_2";
	    String username = "root";
	    String password = "mysqlpass";

	    System.out.println("Connecting database...");

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        System.out.println("Database connected!");
	        
	        String QUERY = "SELECT FName FROM Students";
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(QUERY);
	        while(rs.next()){
	            System.out.println(rs.getString("FName"));
	        }
	    } catch (SQLException e) {
	        throw new IllegalStateException("Cannot connect the database!", e);
	    }
	      SpringApplication.run(DataApplication.class, args);
	}	
}
