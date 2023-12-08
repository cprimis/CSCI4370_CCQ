package com.Spotify.data;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Track;

public class SpotifySong {
	
	private String name;
	private ArtistSimplified[] artists;
	private AlbumSimplified album;
	private String album_name;
	private String album_type;
	private String artists_toString;
	private String id;
	private String uri;

	public SpotifySong(String name, ArtistSimplified[] artists, AlbumSimplified album, String id, String uri) {
		this.name = name;
		this.artists = artists;
		this.artists_toString = "";
		this.album = album;
		this.album_name = album.getName();
		this.album_type = album.getAlbumType().getType();
		this.id = id;
		this.uri = uri;

		for(ArtistSimplified artist : artists) {
			this.artists_toString += artist.getName() + ", ";
		} // for
		this.artists_toString = artists_toString.substring(0,artists_toString.length() - 2);
	} // SpotifySong
	
	public SpotifySong(Track track) {
		this.name = track.getName();
		this.artists = track.getArtists();
		this.artists_toString = "";
		this.album = track.getAlbum();
		this.album_name = this.album.getName();
		this.id = track.getId();
		this.uri = track.getId();
		for(ArtistSimplified artist : this.artists) {
			this.artists_toString += artist.getName() + ", ";
		} // for
	} // SpotifySong
	
	@Override
	public String toString() {

		return "SpotifySong{" 
				+ "name = " 	+ name + " | "
				+ "artists = "  + artists_toString + " | "
				+ "album = " 	+ album_name + " | "
				+ "id = " 		+ id + " | "
				+ "URI = " 		+ uri + "}";
	} // toString
	
    public String getName() {
        return name;
    }

    public ArtistSimplified[] getArtists() {
        return artists;
    }

    public AlbumSimplified getAlbum() {
        return album;
    }

    public String getAlbumName() {
        return album_name;
    }

    public String getArtistsToString() {
        return artists_toString;
    }

    public String getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }
    
    public String getAlbumType() {
    	return album_type;
    }

}
