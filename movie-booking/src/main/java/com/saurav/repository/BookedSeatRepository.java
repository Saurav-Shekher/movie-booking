package com.saurav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.entity.BookedSeat;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {

    List<BookedSeat> findByBookingShowId(Long showId);
    List<BookedSeat> findByShowIdAndSeatNumberIn(Long showId, List<String> seatNumbers);
}