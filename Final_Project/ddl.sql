CREATE DATABASE IF NOT EXISTS Spotify;
USE Spotify;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    salt BLOB NOT NULL,
    password CHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS Artist (
  Artist_Name VARCHAR(255),
  Artist_ID INT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Album (
  Album_Name VARCHAR(255),
  Album_ID INT PRIMARY KEY,
  Album_type VARCHAR(255),
  Artist_ID INT,
  FOREIGN KEY (Artist_ID) REFERENCES Artist(Artist_ID)
);

CREATE TABLE IF NOT EXISTS Track (
  Track_ID INT PRIMARY KEY,
  Track VARCHAR(255),
  Duration_ms INT,
  Album_ID INT,
  FOREIGN KEY (Album_ID) REFERENCES Album(Album_ID)
);

CREATE TABLE IF NOT EXISTS Musicality (
  Musicality_ID INT PRIMARY KEY,
  Track_ID INT,
  Tempo DECIMAL(10, 5),
  Musicality_Key INT,
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE IF NOT EXISTS Energy (
  Energy_ID INT PRIMARY KEY,
  Track_ID INT,
  Danceability DECIMAL(10, 5),
  Energy DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE IF NOT EXISTS Human_Connection (
  Human_Connection_ID INT PRIMARY KEY,
  Track_ID INT,
  Liveness DECIMAL(10, 5),
  Valence DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE IF NOT EXISTS Spoken_Volume (
  Spoken_Volume_ID INT PRIMARY KEY,
  Track_ID INT,
  Loudness DECIMAL(10, 5),
  Instrumentalness DECIMAL(10, 5),
  Speechiness DECIMAL(10, 5),
  Acousticness DECIMAL(10, 5),
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE IF NOT EXISTS Spotify_YouTube (
  YouTube_ID INT PRIMARY KEY,
  Track_ID INT,
  Views BIGINT,
  Streams INT,
  FOREIGN KEY (Track_ID) REFERENCES Track(Track_ID)
);

CREATE TABLE IF NOT EXISTS YouTube_Video (
  YouTube_Video_ID INT PRIMARY KEY,
  YouTube_ID INT,
  Title VARCHAR(255),
  Channel VARCHAR(255),
  Licensed VARCHAR(5),
  Official_Video VARCHAR(5),
  URL VARCHAR(255),  
  FOREIGN KEY (YouTube_ID) REFERENCES Spotify_YouTube(YouTube_ID)
);

CREATE TABLE IF NOT EXISTS Performance (
  Performance_ID INT PRIMARY KEY,
  YouTube_Video_ID INT,
  Likes INT,
  Comments INT,
  FOREIGN KEY (YouTube_Video_ID) REFERENCES YouTube_Video(YouTube_Video_ID)
);

