package com.saurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}