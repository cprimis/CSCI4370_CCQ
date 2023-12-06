-- Top 10 tracks with Highest Tempo (from Musicality Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Musicality.Musicality_Key, Musicality.Tempo
  FROM Track 
  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Musicality.Tempo DESC 
  LIMIT 10;

-- Mean Tempo
SELECT AVG(Tempo) as Mean_Tempo 
  FROM Musicality;


-- Top 10 Tracks with Highest Energy (from Energy Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Energy.Danceability, Energy.Energy
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy.Energy DESC 
  LIMIT 10;

-- Mean Energy
SELECT AVG(Energy) as Mean_Energy
  FROM Energy;


-- Top 10 Tracks with Highest Danceability (from Energy Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Energy.Energy, Energy.Danceability
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy.Danceability DESC 
  LIMIT 10;

-- Mean Danceability
SELECT AVG(Danceability) as Mean_Danceability
  FROM Energy;


-- Top 10 Tracks with Highest Energy and Danceability Metric together, taken as average of both (From Energy Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Energy.Energy, Energy.Danceability, 
  (Energy + Danceability) / 2 AS Energy_Danceability
  FROM Track
  JOIN Energy ON Track.Track_ID = Energy.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Energy_Danceability DESC
  LIMIT 10;

-- Mean Energy_Danceability
Select AVG((Energy + Danceability) / 2) as Mean_Energy_Danceability
  FROM Track JOIN Energy ON Track.Track_ID = Energy.Track_ID;


--  Top 10 Tracks with Highest Valence (from Human_Connection Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Human_Connection.Liveness, Human_Connection.Valence
  FROM Track 
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Human_Connection.Valence DESC 
  LIMIT 10;

-- Mean Valence
SELECT AVG(Valence) as Mean_Valence
  FROM Human_Connection;


--  Top 10 Tracks with Highest Loudness (from Spoken_Volume Table)
SELECT Track.Track_ID, Track.Track, Artist_Name, Spoken_Volume.Instrumentalness, Spoken_Volume.Speechiness, Spoken_Volume.Acousticness, Spoken_Volume.Loudness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID
  JOIN Album ON Track.Album_ID = Album.Album_ID
  JOIN Artist on Album.Artist_ID = Artist.Artist_ID
  ORDER BY Spoken_Volume.Loudness DESC 
  LIMIT 10;

-- Mean Loudness
SELECT AVG(Loudness) as Mean_Loudness
  FROM Spoken_Volume;

--Album Leaderboard (Most Tracks)
-- Album leaderboard with the most tracks
SELECT Album.Album_ID, Album.Album_Name, COUNT(Track.Track_ID) AS TrackCount
FROM Album
LEFT JOIN Track ON Album.Album_ID = Track.Album_ID
GROUP BY Album.Album_ID, Album.Album_Name
ORDER BY TrackCount DESC;

