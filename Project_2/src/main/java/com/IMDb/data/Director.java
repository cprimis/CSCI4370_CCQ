package com.IMDb.data;

public class Director {
	
	private String director_id;
	private String director_name;
	
	public Director(String director_id, String director_name) {
		this.director_id = director_id;
		this.director_name = director_name;
	} // Director

	public String toString() {
		return "Director name: " + director_name + "\n" + "Director ID: " + director_id + "\n";
	} // toString
	
} // Director
