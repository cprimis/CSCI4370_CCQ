-- Insert
-- http://localhost:8080/insert
  -- This query returns the Ratings table with the most recent comments at the top. The result is displayed on the webpage.
  SELECT * FROM Ratings ORDER BY rating_id DESC;
  -- This query returns all of the movies in the Movie table. The result is used in a dropdown for the user to select a movie to rate.
  SELECT * FROM Movie;
-- http://localhost:8080/submitinsert
  -- This query returns the ID of the most recent rating, since rating ID is just an increasing integer. This is used to assign the new review to the next integer for the rating ID.
  SELECT MAX(rating_id) AS "max" FROM Ratings;
  -- This inserts the new review into the Ratings table using the user input on the website form.
  INSERT INTO Ratings VALUES ('" + rating_id + "','" + real_name + "','" + username + "','" + movie_name "','" + user_rating + "','" + user_review + "');
  
-- Delete
-- https://localhost:8080/delete
  -- This query returns the Ratings table with the most recent comments at the top. The result is displayed on the webpage.
  SELECT * FROM Ratings ORDER BY rating_id DESC;
  -- This query returns all of the movies in the Movie table. The result is used to ensure that there are movies available to access and write reviews.
  SELECT * FROM Movie;
-- https://localhost:8080/submitdelete
  -- This query deletes the row of the review in the Ratings table based on the specific rating ID the user inputs using the website form.
  DELETE FROM Ratings WHERE rating_id = + rating_id; 

-- User Leaderboard
-- http://localhost:8080/leaderboard
  -- This query returns the top 10 users with the most reviews in the database. This query aggregates the Ratings table. The result is displayed on the webpage.
  SELECT username, COUNT(*) AS "review_count" FROM Ratings GROUP BY username ORDER BY COUNT(*) DESC LIMIT 10;

-- Reviews by Directors
-- http://localhost:8080/view_reviews_director
  -- This query returns all of the reviews in the database about movies directed by each specific director. The result is displayed on the webpage. 
  SELECT DISTINCT director_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Directors NATURAL JOIN Directors ORDER BY director_name;

-- Reviews by Actors
-- http://localhost:8080/view_reviews_actor
  -- This query returns all of the reviews in the database about movies with casts that include each specific actor. The result is displayed on the webpage.
  SELECT DISTINCT cast_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Actors NATURAL JOIN Actors ORDER BY cast_name;

