-- Insert
SELECT movie_name FROM Ratings WHERE 

-- Delete

-- User Leaderboard
SELECT username, COUNT(*) AS "review_count" FROM Ratings GROUP BY username ORDER BY COUNT(*) DESC LIMIT 10;

-- Reviews by Directors
SELECT * FROM 
SELECT DISTINCT director_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Directors NATURAL JOIN Directors ORDER BY director_name;

-- Reviews by Actors
SELECT * FROM 
SELECT DISTINCT cast_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Actors NATURAL JOIN Actors ORDER BY cast_name;
