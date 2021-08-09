Liquibase scripts

create database  enterprise_db;

use database enterprise_db;

CREATE TABLE UserDetail (
    UserId int NOT NULL AUTO_INCREMENT,
    UserName varchar(255) NOT NULL,
	Password varchar(255),
    Gender varchar(255),
	PhoneNumber varchar(255),
	Email varchar(255),
	PRIMARY KEY (UserId)
 );
 
 
 ALTER TABLE `UserDetail` ADD UNIQUE `unique_index`(`UserName`, `PhoneNumber`, `Email`);
 