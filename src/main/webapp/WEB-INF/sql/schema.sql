CREATE TABLE IF NOT EXISTS EMPLOYEE (
	id INT,
	fname VARCHAR(35),
	lname VARCHAR(35),
	username VARCHAR(35),
	email VARCHAR(40),
	address VARCHAR(200),
	phno VARCHAR(11),
	country VARCHAR(30),
	state VARCHAR(30),
	zip INT,
	remote TINYINT(1) NOT NULL,
	jobtype VARCHAR(15),
	profile BLOB
	);
CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL
	);
insert into users values(1,"admin","admin");