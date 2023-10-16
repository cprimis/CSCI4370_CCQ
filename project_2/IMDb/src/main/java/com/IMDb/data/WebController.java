package com.IMDb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@Controller
public class WebController {

    List<Movie> movies;

    public WebController() {
        movies = new ArrayList<>();
        movies.add(new Movie("Title 1", 0, "Author 1", 2002, 0, null));
        movies.add(new Movie("Title 2", 0, "Author 2", 2012, 0, null));
        movies.add(new Movie("Title 3", 0, "Author 3", 2013, 0, null));
        movies.add(new Movie("Title 4", 0, "Author 4", 2015, 0, null));
        movies.add(new Movie("Title 4", 0, "Author 4", 2015, 0, null));
        movies.add(new Movie("Title 4", 0, "Author 4", 2015, 0, null));
        movies.add(new Movie("Title 4", 0, "Author 4", 2023, 0, null));
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/Project_2?" +
                                        "user=root&password=mysqlpass");
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from Movie;");

                int colCount = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    for(int i = 1; i <= colCount; i++)
                        System.out.print(rs.getString(i) + "\t");
                    System.out.println();
                }
            }
            catch (SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            finally {
                // it is a good idea to release
                // resources in a finally{} block
                // in reverse-order of their creation
                // if they are no-longer needed

                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { } // ignore

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { } // ignore

                    stmt = null;
                }
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    
    @GetMapping("/hello")
    @ResponseBody
    public String helloEndpoint() {
        return "<html><body><h1>"
                    + new Random().nextInt(100) 
                    +"</h1></body></html>";
    }

    @GetMapping("/webpage")
    public ModelAndView webpage() {
        ModelAndView mv = new ModelAndView("hellotemplate");
        String message = "DB class 4370 " + new Random().nextInt(100);
        mv.addObject("message", message);
        mv.addObject("books", movies);
        return mv;
    }

    @PostMapping("/submitform")
    public String formsubmit(@ModelAttribute Movie movie) {
        movies.add(movie);
        return "redirect:/webpage";
    }
    
    @GetMapping("/home")
    public ModelAndView home() {
    	ModelAndView mv = new ModelAndView("hometemplate");
    	return mv;
    }


}
