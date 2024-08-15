CREATE TABLE IF NOT EXISTS employee (
	id INT PRIMARY KEY, 
	fname VARCHAR(35) NOT NULL,
	lname VARCHAR(35) NOT NULL,
	username VARCHAR(35),
	email VARCHAR(100) NOT NULL,
	address VARCHAR(100) NOT NULL,
	phno INT NOT NULL,
	country VARCHAR(100) NOT NULL,
	state VARCHAR(100) NOT NULL,
	zip INT NOT NULL,
	status VARCHAR(25) NOT NULL,
	jobtype VARCHAR(25) NOT NULL,
	pic blob NOT NULL
	);
CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL
	);
insert into users values(1,"admin","admin");