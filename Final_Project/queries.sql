-- Top 10 tracks with highest musicality
SELECT Track.Track_ID, Track.Track, Musicality.Tempo, Musicality.Musicality_Key
  FROM Track 
  JOIN Musicality ON Track.Track_ID = Musicality.Track_ID 
  ORDER BY Musicality.Tempo DESC 
  LIMIT 10;
-- Mean Tempo
SELECT AVG(Tempo) as Mean_Tempo 
  FROM Musicality;

-- Top 10 Tracks with Highest energy
SELECT Track.Track_ID, Track.Track, Energy.Energy
  FROM Track 
  JOIN Energy ON Track.Track_ID = Energy.Track_ID 
  ORDER BY Energy.Energy DESC 
  LIMIT 10;

SELECT AVG(Energy) as Mean_Energy
  FROM Energy;

--  Top 10 Tracks with Highest Human connection
SELECT Track.Track_ID, Track.Track, Human_Connection.Liveness, Human_Connection.Valence
  FROM Track 
  JOIN Human_Connection ON Track.Track_ID = Human_Connection.Track_ID 
  ORDER BY Human_Connection.Valence DESC 
  LIMIT 10;

SELECT AVG(Valence) as Mean_Valence
  FROM Human_Connection;
