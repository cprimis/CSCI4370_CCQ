DROP DATABASE Project_2 IF EXISTS;

CREATE DATABASE Project_2;
USE Project_2;

DROP TABLE Movies IF EXISTS;
DROP TABLE Directors IF EXISTS;
DROP TABLE Actors IF EXISTS;
DROP TABLE Movies_Directors IF EXISTS;
DROP TABLE Movies_Actors IF EXISTS;
DROP TABLE Ratings IF EXISTS;

CREATE TABLE `Movie` (
  `rank` INT,
  `movie_name` VARCHAR(255) PRIMARY KEY,
  `release_year` VARCHAR(255),
  `imdb_rating` DECIMAL(2,1),
  `duration` INT,
  `genre` VARCHAR(255)
);

CREATE TABLE `Actors` (
  `cast_id` VARCHAR(255) PRIMARY KEY,
  `cast_name` VARCHAR(255)
);

CREATE TABLE `Directors` (
  `director_id` VARCHAR(255) PRIMARY KEY,
  `director_name` VARCHAR(255)
);

CREATE TABLE `Movie_Actors` (
  `movie_name` VARCHAR(255),
  `cast_id` VARCHAR(255),
  FOREIGN KEY (`movie_name`) REFERENCES `Movie`(`movie_name`),
  FOREIGN KEY (`cast_id`) REFERENCES `Actors`(`cast_id`)
);

CREATE TABLE `Movies_Directors` (
  `movie_name` VARCHAR(255),
  `director_id` VARCHAR(255),
  FOREIGN KEY (`movie_name`) REFERENCES `Movie`(`movie_name`),
  FOREIGN KEY (`director_id`) REFERENCES `Directors`(`director_id`)
);

CREATE TABLE `Ratings` (
  `rating_id` INT PRIMARY KEY,
  `real_name` VARCHAR(255),
  `username` VARCHAR(255),
  `movie_name` VARCHAR(255),
  `user_rating` VARCHAR(255),
  `user_review` VARCHAR(255),
  FOREIGN KEY (`movie_name`) REFERENCES `Movie`(`movie_name`)
);

