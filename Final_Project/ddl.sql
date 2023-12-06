CREATE DATABASE IF NOT EXISTS Spotify;
USE Spotify;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    salt BLOB NOT NULL,
    password CHAR(128) NOT NULL
);

CREATE TABLE Artist (
  Artist_Name VARCHAR(255),
  Artist_ID INT PRIMARY KEY
);

CREATE TABLE Album (
  Album_Name VARCHAR(255),
  Album_ID INT PRIMARY KEY,
  Album_type VARCHAR(255),
  Artist_ID INT,
  FOREIGN KEY (Artist_ID) REFERENCES Artist(Artist_ID)
);

CREATE TABLE Track (
  Track_ID INT PRIMARY KEY,
  Track VARCHAR(255),
  Duration_ms INT,
  Album_ID INT,
  FOREIGN KEY (Album_ID) REFERENCES Album(Album_ID)
);

CREATE TABLE Musicality (
  Musicality_ID INT PRIMARY KEY,
  Track_ID INT,
  Tempo DECIMAL(10, 5),
  Musicality_Key INT,
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE Energy (
  Energy_ID INT PRIMARY KEY,
  Track_ID INT,
  Danceability DECIMAL(10, 5),
  Energy DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE Human_Connection (
  Human_Connection_ID INT PRIMARY KEY,
  Track_ID INT,
  Liveness DECIMAL(10, 5),
  Valence DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE Spoken_Volume (
  Spoken_Volume_ID INT PRIMARY KEY,
  Track_ID INT,
  Loudness DECIMAL(10, 5),
  Instrumentalness DECIMAL(10, 5),
  Speechiness DECIMAL(10, 5),
  Acousticness DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE Spotify_YouTube (
  YouTube_ID INT PRIMARY KEY,
  Track_ID INT,
  Views INT,
  Streams INT,
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE YouTube_Video (
  YouTube_Video_ID INT PRIMARY KEY,
  YouTube_ID INT,
  Title VARCHAR(255),
  Channel VARCHAR(255),
  Licensed BOOLEAN,
  Official_Video BOOLEAN,
  FOREIGN KEY (YouTube_ID) REFERENCES Spotify_YouTube(YouTube_ID)
);

CREATE TABLE Performance (
  Performance_ID INT PRIMARY KEY,
  YouTube_Video_ID INT,
  Likes INT,
  Comments INT,
  FOREIGN KEY (YouTube_Video_ID) REFERENCES YouTube_Video(YouTube_Video_ID)
);

