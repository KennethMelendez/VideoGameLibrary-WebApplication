DROP DATABASE videogamelibrary;

CREATE DATABASE IF NOT EXISTS videogamelibrary;

USE videogamelibrary;

CREATE TABLE IF NOT EXISTS videogames (
	videogameid int auto_increment NOT NULL,
    title tinytext,
    releasedate date,
    publisher tinytext,
    developer tinytext,
    platforms tinytext,
    description text,
    PRIMARY KEY(videogameid)
);



CREATE TABLE IF NOT EXISTS users (
	userid int auto_increment NOT NULL,
    firstname varchar(25),
    lastname varchar(25),
    username varchar(25),
    `password` varchar(10),
    `enabled` tinyint(1),
    PRIMARY KEY (userid) ,
    KEY username(username) 
);

CREATE TABLE IF NOT EXISTS authorities (
	username varchar(25),
	authorities varchar(20)
);

CREATE TABLE IF NOT EXISTS usersvideogames (
	userid int,
    videogamesid int
);

ALTER TABLE usersvideogames 
ADD CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users(userid)  ON DELETE CASCADE,
ADD CONSTRAINT fk_videogames FOREIGN KEY (videogamesid) REFERENCES videogames(videogameid) ON DELETE CASCADE;


ALTER TABLE authorities 
ADD CONSTRAINT fk_username FOREIGN KEY(username) REFERENCES users(username) ON DELETE CASCADE;



