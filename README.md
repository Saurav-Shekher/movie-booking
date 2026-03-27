# Movie Ticket Booking Platform

## Overview

This project is a simplified backend system for an **online movie ticket booking platform**.
It allows users to browse theatres showing a movie and book seats for a selected show.

The system is built using **Java, Spring Boot, Spring Data JPA, and H2 Database**.

---

# Tech Stack

* Java
* Spring Boot
* Spring Data JPA (ORM)
* H2 In-Memory Database
* Maven
* REST APIs

---

# Key Features

### 1. Browse Theatres Running a Movie

Users can search for theatres running a specific movie in a city on a given date.

Returns:

* Theatre name
* Show timings

Example API

```
GET /movies/shows?movieName=Avengers&city=Bangalore&date=2026-04-01
```

Example Response

```
[
  {
    "theatreName": "PVR Orion",
    "shows": [
      {"showId": 1, "showTime": "10:00:00"},
      {"showId": 2, "showTime": "14:00:00"}
    ]
  },
  {
    "theatreName": "INOX Garuda",
    "shows": [
      {"showId": 3, "showTime": "12:00:00"}
    ]
  }
]
```

---

### 2. Book Movie Tickets

Users can book seats for a specific show.

API

```
POST /booking
```

Request

```
{
  "showId": 1,
  "userName": "Saurav",
  "seats": ["A1","A2"]
}
```

Response

```
{
  "bookingId": 10,
  "confirmedSeats": ["A1","A2"]
}
```

---

# Project Structure

```
controller
service
repository
entity
dto
exception
```

Flow

```
Controller → Service → Repository → Database
```

---

# Database Tables

Main tables used:

* movie
* theatre
* screen
* show
* booking
* booked_seat

Important constraint to prevent duplicate booking:

```
UNIQUE(show_id, seat_number)
```

This ensures **a seat cannot be booked twice for the same show**.

---

# Concurrency Handling

Seat booking uses:

```
@Transactional
```

and a **database unique constraint** to prevent multiple users from booking the same seat at the same time.

---

# Error Handling

Custom exceptions are used for clean API responses.

Examples

| Scenario            | HTTP Status |
| ------------------- | ----------- |
| Show not found      | 404         |
| Seat already booked | 409         |

---

# Running the Project

Run application:

```
mvn spring-boot:run
```

Application URL

```
http://localhost:8080
```

---

# H2 Database Console

```
http://localhost:8080/h2-console
```

Credentials

```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:
```

---

# Design Considerations

* Clean layered architecture
* DTO based API responses
* Transactional booking logic
* Database constraint to prevent double booking
* Simple structure for easy scalability

---

# Future Improvements

* Payment gateway integration
* Redis caching for shows
* Distributed locking for seat booking
* Microservice architecture
* Authentication and user accounts
