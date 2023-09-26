package uga.cs4370.impl;

import java.util.Arrays;
import java.util.List;

import uga.cs4370.mydb.*;

public class Driver {
	
	
	
	public static void main(String[] args) {
		



		RelationBuilder rb = new RelationBuilderImpl();
		Relation r = rb.newRelation("Student", 
				Arrays.asList("ID", "name", "major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
		Relation r3 = rb.newRelation("Student", 
				Arrays.asList("ID", "name", "major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));		
		try {
			Relation r2 = rb.newRelation("Student", 
					Arrays.asList("ID1", "name"), 
					Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
			System.out.println(r2.getName());
		} catch(IllegalArgumentException iae) {
//			System.err.println(iae);
		} // try

		Cell c1 = new Cell(1001);
		Cell c2 = new Cell("Chris Primis");
		Cell c3 = new Cell("Data Science");
		
		List<Cell> t1 = Arrays.asList(c1,c2,c3);
		
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

		Cell c16 = new Cell(5678);
		Cell c17 = new Cell("David Williams");
		Cell c18 = new Cell("Biology");
		
		Cell c19 = new Cell(9012);
		Cell c20 = new Cell("Eva Green");
		Cell c21 = new Cell("English Literature");

		Cell c22 = new Cell(3456);
		Cell c23 = new Cell("Frank Miller");
		Cell c24 = new Cell("History");

		Cell c25 = new Cell(7890);
		Cell c26 = new Cell("Grace Lee");
		Cell c27 = new Cell("Geography");

		Cell c28 = new Cell(1234);
		Cell c29 = new Cell("Henry Ford");
		Cell c30 = new Cell("Economics");

		Cell c31 = new Cell(5678);
		Cell c32 = new Cell("Irene Adler");
		Cell c33 = new Cell("Psychology");
		
		Cell c34 = new Cell(5678.10);
		Cell c35 = new Cell(1);
		Cell c36 = new Cell("Psychology");


		List<Cell> t2 = Arrays.asList(c4,c5,c6);
		List<Cell> t3 = Arrays.asList(c7,c8,c9);
		List<Cell> t4 = Arrays.asList(c10,c11,c12);
		List<Cell> t5 = Arrays.asList(c13,c14,c15);
		List<Cell> t6 = Arrays.asList(c16,c17,c18);
		List<Cell> t7 = Arrays.asList(c4,c8,c12);		
		r.insert(t1);
		r.print();
		r.insert(t2);
		r.insert(t3);		
		r.insert(t4);
		r.insert(t5);		
		r.insert(t6);
		r.insert(t7);
		List<List<Cell>> copy_of_r = r.getRows();
		
		r.insert(c19,c20,c21);
		r.insert(c22,c23,c24);
		r.insert(c25,c26,c27);
		r.insert(c28,c29,c30);
		r.insert(c31,c32,c33);
		r.insert(c31,c32,c30);
		try {
			r.insert(c34,c35,c36);
		} catch(Exception e) {
			
		} // try

		r.print();
		System.out.println(copy_of_r.toString());
		for(List<Cell> row_of_r : copy_of_r) {
			r3.insert(row_of_r);
		}
		r3.print();
		
	} // main
} // Driver
