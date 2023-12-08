-------------------------------------------------------------------------------------------------------------------

-- All tracks in the database w/ all characteristics
-- http://localhost:8080
SELECT Track.Track, Artist_Name, Album_Name, Musicality.Tempo, Musicality.Musicality_Key, 
    Energy.Energy, Energy.Danceability, Human_Connection.Valence, Human_Connection.Liveness,
    Spoken_Volume.Loudness, Spoken_Volume.Instrumentalness, Spoken_Volume.Speechiness, Spoken_Volume.Acousticness
  FROM Track 
  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Track.Track;

-------------------------------------------------------------------------------------------------------------------

-- ??
-- http://localhost:8080/insert

-------------------------------------------------------------------------------------------------------------------

-- Top 10 tracks with Highest Tempo (from Musicality Table)
-- http://localhost:8080/musicality
SELECT Track.Track, Artist_Name, Musicality.Tempo 
  FROM Track 
  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Musicality.Tempo DESC 
  LIMIT 10;

-- Mean Tempo of all tracks (from Musicality Table)
-- http://localhost:8080/musicality
SELECT AVG(Tempo) as Mean_Tempo 
  FROM Musicality;

-- Mean Key of all tracks (from Musicality Table)
-- http://localhost:8080/musicality
SELECT AVG(Musicality_Key) as Mean_Key 
  FROM Musicality;

-------------------------------------------------------------------------------------------------------------------

-- Top 10 Tracks with Highest Energy (from Energy Table)
-- http://localhost:8080/energy
SELECT Track.Track, Artist_Name, Energy.Energy 
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy.Energy DESC 
  LIMIT 10;

-- Mean Energy of all tracks (from Energy Table)
-- http://localhost:8080/energy
SELECT AVG(Energy) as Mean_Energy
  FROM Energy;

-- Top 10 Tracks with Highest Danceability (from Energy Table)
-- http://localhost:8080/energy
SELECT Track.Track, Artist_Name, Energy.Danceability 
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy.Danceability DESC 
  LIMIT 10;

-- Mean Danceability of all tracks (from Energy Table)
-- http://localhost:8080/energy
SELECT AVG(Danceability) as Mean_Danceability
  FROM Energy;

-- Top 10 Tracks with Highest Energy and Danceability Metric together, taken as an average of both (From Energy Table)
-- http://localhost:8080/energy
SELECT Track.Track, Artist_Name, (Energy + Danceability) / 2 AS Energy_Danceability
  FROM Track
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy_Danceability DESC
  LIMIT 10;

-- Mean Energy_Danceability of all tracks (from Energy Table)
-- http://localhost:8080/energy
SELECT AVG((Energy + Danceability) / 2) as Mean_Energy_Danceability
  FROM Track JOIN Energy ON Track.Track_ID = Energy.Track_ID;

-------------------------------------------------------------------------------------------------------------------

-- Top 10 Tracks with Highest Loudness (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT Track.Track, Artist_Name, Spoken_Volume.Loudness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Spoken_Volume.Loudness DESC 
  LIMIT 10;

-- Mean Loudness of all tracks (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT AVG(Loudness) as Mean_Loudness
  FROM Spoken_Volume;

-- Top 10 Tracks with Highest Instrumentalness (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT Track.Track, Artist_Name, Spoken_Volume.Instrumentalness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Spoken_Volume.Instrumentalness DESC 
  LIMIT 10;

-- Mean Instrumentalness of all tracks (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT AVG(Instrumentalness) as Mean_Instrumentalness 
  FROM Spoken_Volume;

-- Top 10 Tracks with Highest Speechiness (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT Track.Track, Artist_Name, Spoken_Volume.Speechiness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Spoken_Volume.Speechiness DESC 
  LIMIT 10;

-- Mean Speechiness of all tracks (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT AVG(Speechiness) as Mean_Speechiness
  FROM Spoken_Volume;

-- Top 10 Tracks with Highest Acousticness (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT Track.Track, Artist_Name, Spoken_Volume.Acousticness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Spoken_Volume.Acousticness DESC 
  LIMIT 10;

-- Mean Acousticness of all tracks (from Spoken_Volume Table)
-- http://localhost:8080/volume
SELECT AVG(Acousticness) as Mean_Acousticness
  FROM Spoken_Volume;
  
-------------------------------------------------------------------------------------------------------------------

--  Top 10 Tracks with Highest Valence (from Human_Connection Table)
-- http://localhost:8080/atmosphere
SELECT Track.Track, Artist_Name, Human_Connection.Valence
  FROM Track 
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Human_Connection.Valence DESC 
  LIMIT 10;

-- Mean Valence of all tracks (from Human_Connection Table)
-- http://localhost:8080/atmosphere
SELECT AVG(Valence) as Mean_Valence
  FROM Human_Connection;

--  Top 10 Tracks with Highest Liveness (from Human_Connection Table)
-- http://localhost:8080/atmosphere
SELECT Track.Track, Artist_Name, Human_Connection.Liveness
  FROM Track 
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Human_Connection.Liveness DESC 
  LIMIT 10;

-- Mean Liveness of all tracks (from Human_Connection Table)
-- http://localhost:8080/atmosphere
SELECT AVG(Liveness) as Mean_Liveness
  FROM Human_Connection;

-------------------------------------------------------------------------------------------------------------------

-- Album leaderboard with the most tracks
-- http://localhost:8080/leaderboard
SELECT Album.Album_Name, Artist.Artist_Name, COUNT(Track.Track_ID) AS TrackCount
  FROM Album
  LEFT JOIN Track ON Album.Album_ID = Track.Album_ID
  JOIN Artist ON Album.Artist_ID = Artist.Artist_ID
  GROUP BY Album.Album_ID, Album.Album_Name, Artist.Artist_Name 
  ORDER BY TrackCount DESC LIMIT 50;

-------------------------------------------------------------------------------------------------------------------

-- Get all tracks with a YouTube video link
-- http://localhost:8080/random
SELECT Track.Track_ID 
  FROM Track 
  JOIN Spotify_YouTube ON Track.Track_ID = Spotify_YouTube.Track_ID 
  JOIN YouTube_Video ON Spotify_YouTube.YouTube_ID = YouTube_Video.YouTube_ID 
  JOIN Performance ON YouTube_Video.YouTube_Video_ID = Performance.YouTube_Video_ID 
  WHERE YouTube_Video.URL_YouTube IS NOT NULL;
  
-- Look up YouTube Video based on a Track ID
-- http://localhost:8080/random
SELECT Track.Track, Artist.Artist_Name, YouTube_Video.Title, YouTube_Video.Channel, YouTube_Video.Licensed, YouTube_Video.Official_Video, YouTube_Video.URL_YouTube, Performance.Likes, Performance.Comments
  FROM Track 
  JOIN Spotify_YouTube ON Track.Track_ID = Spotify_YouTube.Track_ID 
  JOIN YouTube_Video ON Spotify_YouTube.YouTube_ID = YouTube_Video.YouTube_ID 
  JOIN Performance ON YouTube_Video.YouTube_Video_ID = Performance.YouTube_Video_ID 
  JOIN Album ON Track.Album_ID = Album.Album_ID 
  JOIN Artist ON Album.Artist_ID = Artist.Artist_ID 
  WHERE Track.Track_ID = ID;
