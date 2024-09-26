DROP DATABASE if exists INFYMOVIE;
CREATE DATABASE INFYMOVIE;
USE  INFYMOVIE;

CREATE TABLE Movie_Details( 
	MOVIE_ID INT auto_increment,
	NAME VARCHAR(50) NOT NULL,
	RATING DECIMAL(4,2) NOT NULL,
constraint MOVIE_ID_PK primary key ( MOVIE_ID )
);

INSERT INTO Movie_Details VALUES(9001, 'Dead Pool', 8.0);
INSERT INTO Movie_Details VALUES(9002, 'The Emoji Movie', 1.5);
INSERT INTO Movie_Details VALUES(9003, 'Dunkirk', 8.5);
INSERT INTO Movie_Details VALUES(9004, 'Spider-Man', 7.9);
INSERT INTO Movie_Details VALUES(9005, 'Atomic Blonde', 7.2);
INSERT INTO Movie_Details VALUES(9006, 'Despicable Me 3', 6.4);
INSERT INTO Movie_Details VALUES(9007, 'Wall-E', 8.0);
INSERT INTO Movie_Details VALUES(9008, 'Black Panther', 8.5);
INSERT INTO Movie_Details VALUES(9009, 'MI Fallout', 8.5);
INSERT INTO Movie_Details VALUES(9010, 'Incredibles 2', 6.3);
INSERT INTO Movie_Details VALUES(9011, 'Star Trek Into Darkness', 7.9);
INSERT INTO Movie_Details VALUES(9012, 'Aqua man', 8.9);
INSERT INTO Movie_Details VALUES(9013, 'Dead Pool 2', 7.5);
INSERT INTO Movie_Details VALUES(9014, 'First man', 3.3);
INSERT INTO Movie_Details VALUES(9015, 'Oceans 11', 5.5);
INSERT INTO Movie_Details VALUES(9016, 'Fantastic 4', 8.9);
INSERT INTO Movie_Details VALUES(9017, 'Blue Streak', 4.6);
INSERT INTO Movie_Details VALUES(9018, 'Bad Boys', 7.9);
INSERT INTO Movie_Details VALUES(9019, 'Bad Boys 2', 6.5);
commit;


