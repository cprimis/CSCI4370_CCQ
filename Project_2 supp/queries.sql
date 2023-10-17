// -- Insert
// http://localhost:8080/insert
  // This query returns the Ratings table with most recent comments at the top. The result is displayed on the webpage.
  SELECT * FROM Ratings ORDER BY rating_id DESC;
// http://localhost:8080/submitinsert
  // This query returns the ID of the most recent rating, since rating ID is just an increasing integer. This is used to assign the new review to the next integer for the rating ID.
  SELECT MAX(rating_id) AS "max" FROM Ratings;
  // This inserts the new review into the Ratings table using the user input on the website form.
  INSERT INTO Ratings VALUES ('" + rating_id + "','" + real_name + "','" + username + "','" + movie_name "','" + user_rating + "','" + user_review + "');
  
// -- Delete

// -- User Leaderboard
// http://localhost:8080/leaderboard
  // This query returns the top 10 users with the most reviews in the database. The result is displayed on the webpage.
  SELECT username, COUNT(*) AS "review_count" FROM Ratings GROUP BY username ORDER BY COUNT(*) DESC LIMIT 10;

// -- Reviews by Directors
SELECT * FROM 
SELECT DISTINCT director_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Directors NATURAL JOIN Directors ORDER BY director_name;

// -- Reviews by Actors
SELECT * FROM 
SELECT DISTINCT cast_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Actors NATURAL JOIN Actors ORDER BY cast_name;
