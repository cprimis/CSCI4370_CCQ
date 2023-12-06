-- Top 10 tracks with highest Tempo (from Musicality)
SELECT Track.Track_ID, Track.Track, Musicality.Tempo, Musicality.Musicality_Key
  FROM Track 
  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID 
  ORDER BY Musicality.Tempo DESC 
  LIMIT 10;
-- Mean Tempo
SELECT AVG(Tempo) as Mean_Tempo 
  FROM Musicality;

-- Top 10 Tracks with Highest Energy (from Energy)
SELECT Track.Track_ID, Track.Track, Energy.Energy, Energy.Danceability
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID 
  ORDER BY Energy.Energy DESC 
  LIMIT 10;

-- Mean Energy
SELECT AVG(Energy) as Mean_Energy
  FROM Energy;

-- Top 10 Tracks with Highest Danceability (from Energy)
SELECT Track.Track_ID, Track.Track, Energy.Energy, Energy.Danceability
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID 
  ORDER BY Energy.Danceability DESC 
  LIMIT 10;

-- Mean Danceability
SELECT AVG(Danceability) as Mean_Danceability
  FROM Danceability;

--  Top 10 Tracks with Highest Valence (from Human connection)
SELECT Track.Track_ID, Track.Track, Human_Connection.Liveness, Human_Connection.Valence
  FROM Track 
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID 
  ORDER BY Human_Connection.Valence DESC 
  LIMIT 10;

-- Mean Valence
SELECT AVG(Valence) as Mean_Valence
  FROM Human_Connection;

--  Top 10 Tracks with Highest Spoken Volume (from Spoken_Volume)
SELECT Track.Track_ID, Track.Track, Spoken_Volume.Loudness, Spoken_Volume.Instrumentalness, Spoken_Volume.Speechiness, Spoken_Volume.Acousticness
  FROM Track 
  JOIN Spoken_Volume ON Track.Track_ID = Spoken_Volume.Track_ID 
  ORDER BY Spoken_Volume.Loudness DESC 
  LIMIT 10;

SELECT AVG(Loudness) as Mean_Loudness
  FROM Spoken_Volume;
