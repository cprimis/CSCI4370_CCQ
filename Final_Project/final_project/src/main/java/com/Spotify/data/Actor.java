package com.Spotify.data;

public class Actor {

	private String cast_id;
	private String cast_name;
	
	public Actor(String cast_id, String cast_name) {
		this.cast_id = cast_id;
		this.cast_name = cast_name;
	} // Actor
	
	@Override
	public String toString() {
		return "Actor name: " + cast_name+ "\n" + "Actor ID: " + cast_id + "\n";
	} // toString
} // Actor
