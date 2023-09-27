package uga.cs4370.mydb.impl;

import java.util.Arrays;
import java.util.List;

import uga.cs4370.mydb.*;

public class Driver {
    
    
    
    public static void main(String[] args) {
        

        RelationBuilder rb = new RelationBuilderImpl();
        Relation test = rb.newRelation("Student", 
                Arrays.asList("ID", "name", "major"), 
                Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
        
        
        Cell c4 = new Cell(1222);
        Cell c5 = new Cell("Jeff Stone");
        Cell c6 = new Cell("Computer Science");
        
        Cell c7 = new Cell(3456);
        Cell c8 = new Cell("Alice Johnson");
        Cell c9 = new Cell("Mathematics");

        Cell c10 = new Cell(7890);
        Cell c11 = new Cell("Bob Smith");
        Cell c12 = new Cell("Physics");

        Cell c13 = new Cell(1234);
        Cell c14 = new Cell("Charlie Brown");
        Cell c15 = new Cell("Chemistry");
        
        List<Cell> t2 = Arrays.asList(c4,c5,c6);
        List<Cell> t3 = Arrays.asList(c7,c8,c9);
        List<Cell> t4 = Arrays.asList(c10,c11,c12);
        List<Cell> t5 = Arrays.asList(c13,c14,c15);
       
        test.insert(t2);
        test.insert(t3);       
        test.insert(t4);
        test.insert(t5);    
        
        Relation test2 = rb.newRelation("Student", 
                Arrays.asList("ID", "name", "major"), 
                Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));

        Cell c16 = new Cell(5678);
        Cell c17 = new Cell("David Williams");
        Cell c18 = new Cell("Biology");
        
        Cell c19 = new Cell(9012);
        Cell c20 = new Cell("Eva Green");
        Cell c21 = new Cell("English Literature");
        
        List<Cell> t6 = Arrays.asList(c16,c17,c18);
        List<Cell> t7 = Arrays.asList(c19,c20,c21);

        test2.insert(t5);
        test2.insert(t6);
        test2.insert(t7);   
        
        Relation cou = rb.newRelation("Courses", 
                Arrays.asList("CourseID", "CName", "Credits"), 
                Arrays.asList(Type.STRING, Type.STRING, Type.INTEGER));
        
        //courses data
        Cell c001 = new Cell("CS01");
        Cell c002 = new Cell("Introduction to Computing");
        Cell c003 = new Cell(3);
        
        Cell c011 = new Cell("CS02");
        Cell c012 = new Cell("Software Development");
        Cell c013 = new Cell(4);
        
        List<Cell> cl00 = Arrays.asList(c001,c002,c003);
        List<Cell> cl01 = Arrays.asList(c011,c012,c013);
        
        cou.insert(cl00);
        cou.insert(cl01);
        
        test.print();
        test2.print();
        cou.print();
        //------------------------------------------------------------
        RA ra = new RAimpl();
        
        // select
        
        // project
        Relation projtest = ra.project(test, Arrays.asList("ID"));
        projtest.print();
        
        // union
        Relation uniontest = ra.union(test, test2);
        uniontest.print();
        
        // diff
        Relation difftest = ra.diff(test, test2);
        difftest.print();
        
        // rename
        test2 = ra.rename(test2, Arrays.asList("ID"), Arrays.asList("StudentID"));
        test2.print();
        
        // cartesianProduct
        Relation carttest = ra.cartesianProduct(cou, test2);
        carttest.print();
        
    } // main
} // Driver
