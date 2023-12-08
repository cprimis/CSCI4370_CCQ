package com.Spotify.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import se.michaelthelin.spotify.*;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.miscellaneous.AudioAnalysis;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;
import com.Spotify.data.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InsertController {
    static String url = "jdbc:mysql://localhost:33306/Spotify";
    static String user = "root";
    static String password = "mysqlpass";
    
    
    private static final String clientId = "49ca40b6f27b4d38b81993e8b194d944";
    private static final String clientSecret = "5957f366781a4706ab7d07350761f29a";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();
    
    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();
    
    public static Paging<Track> searchTrack(String name, String artist) {
        try {
        	final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks("track:" + name + " artist:" + artist).build();
            return searchTracksRequest.execute();
    	} catch (Exception e) {        	
            System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
            return null;
		} // try
    } // searchTrack
    
    public static Track searchTrack(String spotify_id) {
        try {
        	final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            GetTrackRequest getTrackRequest = spotifyApi.getTrack(spotify_id).build();
            return getTrackRequest.execute();
    	} catch (Exception e) {        	
            System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
            return null;
		} // try
    } // searchTrack
    
    public static void insertTrack(String spotify_id) {
        try {
        	final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            AudioAnalysis audioAnalysis = spotifyApi.getAudioAnalysisForTrack(spotify_id).build().execute();
            AudioFeatures audioFeatures  = spotifyApi.getAudioFeaturesForTrack(spotify_id).build().execute();
            Track trackInfo = spotifyApi.getTrack(spotify_id).build().execute();
            SpotifySong spotifySong = new SpotifySong(trackInfo);
            System.out.println(spotifySong.getArtists()[0].getName());

            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement stmt = connection.createStatement();
            
            String artistId = String.format("SELECT Artist_ID FROM Artist "
            		+ "WHERE Artist_Name = '" + spotifySong.getArtists()[0].getName() +"'");
            int artist_id;
            ResultSet rs = stmt.executeQuery(artistId);            
            if(rs.next() == false) {
            	String maxArtistID = "SELECT MAX(Artist_ID) FROM Artist";
            	ResultSet maxArtistID_rs = stmt.executeQuery(maxArtistID);
            	maxArtistID_rs.next();
            	artist_id = maxArtistID_rs.getInt(1) + 1;
            	
            	String artistIns = String.format("INSERT INTO Artist VALUES"
            			+ "('" + spotifySong.getArtists()[0].getName()
            			+ "', " + artist_id + ")");
            	stmt.execute(artistIns);
            } else {
            	artist_id = rs.getInt(1);
            	System.out.println("Artist Exists in DB, ID: " + artist_id);
            } // if
            String albumID = String.format("SELECT Album_ID FROM Album " 
            		+ "WHERE Album_Name = '" + spotifySong.getAlbumName() + "'");
            rs = stmt.executeQuery(albumID);
            int album_id;
            if(rs.next() == false) {
            	String maxAlbumID = "SELECT MAX(Album_ID) FROM Album";
            	ResultSet maxAlbumID_rs = stmt.executeQuery(maxAlbumID);
            	maxAlbumID_rs.next();
            	album_id = maxAlbumID_rs.getInt(1) + 1;
            	
            	String albumIns = String.format("INSERT INTO Album VALUES"
            			+ "('" + spotifySong.getAlbumName()
            			+ "', " + album_id 
            			+ ", '" + spotifySong.getAlbumType()
            			+ "', " + artist_id
            			+ ")");
            	stmt.execute(albumIns);
            } else {
            	album_id = rs.getInt(1);
            	System.out.println("Album Exists in DB, ID: " + album_id);
            } // if
            
            String trackID = String.format("SELECT Track_ID FROM Track" 
            		+ " WHERE Track = '" + trackInfo.getName()
            		+ "' AND Album_ID = " + album_id);
            System.out.println(trackID);
            rs = stmt.executeQuery(trackID);
            int track_id;
            if(rs.next() == false) {
            	String maxTrackID = "SELECT MAX(Track_ID) FROM Track";
            	String maxMusicalityID = "SELECT MAX(Musicality_ID) FROM Musicality";            	
            	String maxEnergyID =  "SELECT MAX(Energy_ID) FROM Energy";
            	String maxSpokenID = "SELECT MAX(Spoken_Volume_ID) FROM Spoken_Volume";
            	String maxConnectionID = "SELECT MAX(Human_Connection_ID) FROM Human_Connection";
            	
            	ResultSet maxTrackID_rs = stmt.executeQuery(maxTrackID);
            	maxTrackID_rs.next();
            	track_id = maxTrackID_rs.getInt(1) + 1;
            	
            	ResultSet maxMusicalityID_rs = stmt.executeQuery(maxMusicalityID);
            	maxMusicalityID_rs.next();
            	int musicality_id = maxMusicalityID_rs.getInt(1) + 1;
            	
            	ResultSet maxEnergyID_rs = stmt.executeQuery(maxEnergyID);
            	maxEnergyID_rs.next();
            	int energy_id = maxEnergyID_rs.getInt(1) + 1;
            	
            	ResultSet maxSpokenID_rs = stmt.executeQuery(maxSpokenID);
            	maxSpokenID_rs.next();
            	int spoken_id = maxSpokenID_rs.getInt(1) + 1;
            	
            	ResultSet maxConnectionID_rs = stmt.executeQuery(maxConnectionID);
            	maxConnectionID_rs.next();
            	int connection_id = maxConnectionID_rs.getInt(1) + 1;
            	
            	String trackIns = "INSERT INTO Track VALUES"
            			+ "(" + track_id
            			+ ", '" + trackInfo.getName()
            			+ "', " + trackInfo.getDurationMs()
            			+ ", " + album_id
            			+ ")";
//            	System.out.println(trackIns);
            	stmt.execute(trackIns);
            	
            	String musicalityIns = "INSERT INTO Musicality VALUES"
            			+ "( " + musicality_id
            			+ ", " + track_id
            			+ ", " + audioFeatures.getTempo()
            			+ ", " + audioFeatures.getKey()
            			+ ")";
//            	System.out.println(musicalityIns);
            	stmt.execute(musicalityIns);
            	
            	String energyIns = "INSERT INTO Energy VALUES"
            			+ "( " + energy_id
            			+ ", " + track_id
            			+ ", " + audioFeatures.getDanceability()
            			+ ", " + audioFeatures.getEnergy()
            			+ ")";
//            	System.out.println(energyIns);
            	stmt.execute(energyIns);
            	
            	String spokenIns = "INSERT INTO Spoken_Volume VALUES"
            			+ "( " + spoken_id
            			+ ", " + track_id
            			+ ", " + audioFeatures.getLoudness()
            			+ ", " + audioFeatures.getInstrumentalness()
            			+ ", " + audioFeatures.getSpeechiness()
            			+ ", " + audioFeatures.getAcousticness()
            			+ ")";
//            	System.out.println(spokenIns);
            	stmt.execute(spokenIns);
            	
            	String connectionIns = "INSERT INTO Human_Connection VALUES"
            			+ "( " + connection_id
            			+ ", " + track_id
            			+ ", " + audioFeatures.getLiveness()
            			+ ", " + audioFeatures.getValence()
            			+ ")";
//            	System.out.println(connectionIns);
            	stmt.execute(connectionIns);
            	
            } else {
            	track_id  = rs.getInt(1);
            	System.out.println("Track Exists in DB, ID: " + track_id);
            	
            } // if
            
    	} catch (Exception e) {        	
            System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} // try
    	
    } // searchTrack

    
    
    @GetMapping("/insert")
    public ModelAndView leaderboard() {
    	ModelAndView mv = new ModelAndView("insert");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            stmt.close();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        } // try
        return mv;
    }
    
    @PostMapping("/submitsearch")
    public ModelAndView formsubmitsearch(String song_name, String artist) {
    	ModelAndView mv = new ModelAndView("insert");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            stmt.close();
            List<SpotifySong> track_list = new ArrayList<>();
            Paging<Track> paging_tracks = searchTrack(song_name,artist);
            Track[] track_arr = paging_tracks.getItems();
            for(Track track : track_arr) {

            	track_list.add(new SpotifySong(track.getName(),track.getArtists(),track.getAlbum(), track.getId(),track.getUri()));
            }
            mv.addObject("track_list",track_list);
   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        return mv;
    } // formsubmitsearch
    
    @PostMapping("/submitinsert")
    public ModelAndView formsubmitinsert(String spotify_id) {
    	ModelAndView mv = new ModelAndView("insert");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String test_search = "1oqNnxue9r4IvSwrsqstW2";
            Track test_track = searchTrack(test_search);
            insertTrack(test_search);

   
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
        return mv;
    } // formsubmitsearch
}
