package com.saurav.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saurav.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
	
	@Query("""
			SELECT s.id, t.name, s.showTime
			FROM Show s
			JOIN s.movie m
			JOIN s.screen sc
			JOIN sc.theatre t
			WHERE m.name = :movieName
			AND t.city = :city
			AND s.showDate = :date
			AND (:showTime IS NULL OR s.showTime = :showTime)
			""")
			List<Object[]> findTheatresByMovieCityDate(
			        String movieName,
			        String city,
			        LocalDate date,
			        LocalTime showTime
			);
}