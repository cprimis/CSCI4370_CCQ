package uga.cs4370.mydb.impl;

import java.util.Arrays;
import java.util.List;

import uga.cs4370.mydb.*;

public class Driver {
	
	
	
	public static void main(String[] args) {
		

		Cell c1 = new Cell(1001);
		Cell c2 = new Cell("Chris Primis");
		Cell c3 = new Cell("Data Science");


		RelationBuilder rb = new RelationBuilderImpl();
		Relation r = rb.newRelation("Student", 
				Arrays.asList("ID", "name", "major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
		try {
			Relation r2 = rb.newRelation("Student", 
					Arrays.asList("ID1", "name"), 
					Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
			System.out.println(r2.getName());
		} catch(IllegalArgumentException iae) {
			System.err.println(iae);
		}
		System.out.println("Continuing..");
		
		r.insert(c1,c2,c3);
		
		
	}


}
