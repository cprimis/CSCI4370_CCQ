-- Insert
SELECT movie_name FROM Ratings WHERE 

-- Delete

-- User Leaderboard

-- Reviews by Directors
SELECT * FROM 
SELECT DISTINCT director_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Directors NATURAL JOIN Directors ORDER BY director_name;

-- Reviews by Actors
SELECT * FROM 
SELECT DISTINCT cast_name, rating_id, user_rating, user_review, Ratings.movie_name FROM Ratings NATURAL JOIN Movie_Actors NATURAL JOIN Actors ORDER BY cast_name;
