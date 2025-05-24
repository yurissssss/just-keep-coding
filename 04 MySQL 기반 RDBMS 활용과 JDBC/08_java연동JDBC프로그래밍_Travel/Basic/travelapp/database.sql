CREATE DATABASE IF NOT EXISTS traveldb;

USE traveldb;

DROP TABLE IF EXISTS tbl_travel;

CREATE TABLE tbl_travel(
                           no 				INT 			NOT NULL 	AUTO_INCREMENT 		PRIMARY KEY,
                           district 		VARCHAR(50) 	NOT NULL,
                           title 			VARCHAR(512) 	NOT NULL,
                           description 	TEXT,
                           address 		VARCHAR(512),
                           phone 			VARCHAR(256)
);

DROP TABLE IF EXISTS tbl_travel_image;

CREATE TABLE tbl_travel_image(
                                 no 			INT 			NOT NULL 	AUTO_INCREMENT		PRIMARY KEY,
                                 filename 	VARCHAR(512) 	NOT NULL,
                                 travel_no 	INT,
                                 CONSTRAINT FOREIGN KEY(travel_no) REFERENCES tbl_travel(no)
                                     ON DELETE CASCADE
);