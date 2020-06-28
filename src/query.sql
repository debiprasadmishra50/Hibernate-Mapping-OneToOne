show databases;

create database Hibernate_OneToOne;

use hibernate_onetoone;

show tables;

create table instructor_detail (
	id 	int(11)  Not Null Auto_Increment Primary Key,
	youtube_channel varchar(45) Default Null,
	hobby 	varchar(45) 	Default Null
	);

create table instructor (
	id  int(11) Not Null Auto_Increment Primary Key,
	first_name varchar(45) Default Null,
	last_name varchar(45) Default Null,
	email varchar(45) Default Null,
	instructor_detail_id int(11) Default Null,
	foreign key instructor_detail_id references instructor_detail (id)
	);

desc instructor;

desc instructor_detail;

select * from instructor;

select * from instructor_detail;

