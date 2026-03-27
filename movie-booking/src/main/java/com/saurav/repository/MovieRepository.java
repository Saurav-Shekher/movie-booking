package com.saurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}