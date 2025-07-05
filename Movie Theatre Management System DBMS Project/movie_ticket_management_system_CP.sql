CREATE DATABASE IF NOT EXISTS movie_ticket_management_system_CP;

USE movie_ticket_management_system_CP;

CREATE TABLE IF NOT EXISTS signup (
  Name CHAR(30) NOT NULL,
  email_id CHAR(50) NOT NULL,
  Contact_number VARCHAR(15) NOT NULL,
  prn_no VARCHAR(20),
  password CHAR(100) NOT NULL,
  confirmed_password CHAR(100) NOT NULL
);

SELECT * FROM signup;

CREATE TABLE IF NOT EXISTS table3 (
  theatre VARCHAR(30) NOT NULL,
  shows VARCHAR(30) NOT NULL,
  tickets INT NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

SELECT * FROM table3;

INSERT INTO table3 (theatre, shows, tickets) VALUES
('Inox', '11:00AM', 250),
('Inox', '7:00AM', 296),
('City pride', '9:00PM', 250),
('Bund garden', '7:00AM', 250),
('PVR', '7:00AM', 255),
('Inox', '9:00PM', 300),
('Inox', '2:00PM', 260),
('Inox', '6:00PM', 250),
('City pride', '6:00PM', 350),
('City pride', '2:00PM', 241),
('City pride', '11:00AM', 300),
('Bund garden', '11:00AM', 300),
('Bund garden', '2:00PM', 250),
('Bund garden', '6:00PM', 350),
('Bund garden', '9:00PM', 250),
('City pride', '7:00AM', 260),
('PVR', '11:00AM', 300),
('PVR', '2:00PM', 250),
('PVR', '6:00PM', 350),
('PVR', '9:00PM', 250);

SELECT * FROM table3;

CREATE TABLE IF NOT EXISTS Suggestion (
  select_movie CHAR(100) NOT NULL,
  des CHAR(200)
);

SELECT * FROM Suggestion;

CREATE TABLE IF NOT EXISTS Contact (
  Name CHAR(30) NOT NULL,
  Email_id CHAR(50) NOT NULL,
  Phone_no VARCHAR(20) NOT NULL,
  Message CHAR(100)
);

SELECT * FROM Contact;

CREATE TABLE IF NOT EXISTS booked (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  no_of_tickets CHAR(20) NOT NULL,
  theater CHAR(100) NOT NULL,
  movie CHAR(100) NOT NULL,
  date CHAR(100) NOT NULL,
  shows CHAR(100) NOT NULL,
  fare INT NOT NULL
);

SELECT * FROM booked;

CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(100) UNIQUE,
  password VARCHAR(100),
  contact_number VARCHAR(15),
  prn_no VARCHAR(20)
);

SELECT * FROM users;

CREATE TABLE IF NOT EXISTS movies (
  movie_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100),
  genre VARCHAR(50),
  duration VARCHAR(20),
  date VARCHAR(30),
  rating DECIMAL(2,1)
);

SELECT * FROM movies;

CREATE TABLE IF NOT EXISTS seats (
  seat_id INT AUTO_INCREMENT PRIMARY KEY,
  theater VARCHAR(100),
  showtime VARCHAR(20),
  seat_number VARCHAR(10),
  is_booked BOOLEAN DEFAULT FALSE
);

SELECT * FROM seats;

CREATE TABLE IF NOT EXISTS payments (
  payment_id INT PRIMARY KEY AUTO_INCREMENT,
  booking_id INT,
  payment_method VARCHAR(50),
  payment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  amount_paid DECIMAL(10,2)
);

SELECT * FROM payments;

