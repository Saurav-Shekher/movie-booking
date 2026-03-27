CREATE TABLE movie (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100),
 language VARCHAR(50),
 genre VARCHAR(50)
);
CREATE TABLE theatre (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100),
 city VARCHAR(100)
);
CREATE TABLE screen (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 screen_name VARCHAR(50),
 theatre_id BIGINT
);
CREATE TABLE show (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 movie_id BIGINT,
 screen_id BIGINT,
 show_date DATE,
 show_time TIME
);

CREATE TABLE booking (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 show_id BIGINT,
 user_name VARCHAR(100),
 booking_time TIMESTAMP
);

CREATE TABLE booked_seat (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 booking_id BIGINT,
 show_id BIGINT,
 seat_number VARCHAR(10),
 CONSTRAINT unique_seat_booking UNIQUE (show_id, seat_number)
);

INSERT INTO movie(id,name,language,genre)
VALUES
(1,'Avengers','English','Action'),
(2,'Pushpa','Telugu','Action');

INSERT INTO theatre(id,name,city)
VALUES
(1,'PVR Orion','Bangalore'),
(2,'INOX Garuda','Bangalore'),
(3,'Cinepolis Forum','Hyderabad');

INSERT INTO screen(id,screen_name,theatre_id)
VALUES
(1,'Screen 1',1),
(2,'Screen 2',2),
(3,'Screen 1',3);

CREATE TABLE seat (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 screen_id BIGINT,
 seat_number VARCHAR(10),
 seat_type VARCHAR(20)
);

INSERT INTO show(id,movie_id,screen_id,show_date,show_time)
VALUES
(1,1,1,'2026-04-01','10:00:00'),
(2,1,1,'2026-04-01','14:00:00'),
(3,1,2,'2026-04-01','12:00:00'),
(4,2,3,'2026-04-01','16:00:00');

INSERT INTO seat(screen_id, seat_number, seat_type) VALUES
(1,'A1','REGULAR'),
(1,'A2','REGULAR'),
(1,'A3','REGULAR'),
(1,'A4','REGULAR'),
(1,'B1','PREMIUM'),
(1,'B2','PREMIUM'),
(1,'B3','PREMIUM'),
(1,'B4','PREMIUM');

INSERT INTO seat(screen_id, seat_number, seat_type) VALUES
(2,'A1','REGULAR'),
(2,'A2','REGULAR'),
(2,'A3','REGULAR'),
(2,'A4','REGULAR'),
(2,'B1','PREMIUM'),
(2,'B2','PREMIUM');

INSERT INTO seat(screen_id, seat_number, seat_type) VALUES
(3,'A1','REGULAR'),
(3,'A2','REGULAR'),
(3,'A3','REGULAR'),
(3,'B1','PREMIUM'),
(3,'B2','PREMIUM');

