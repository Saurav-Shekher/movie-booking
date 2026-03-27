package com.saurav.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.dto.BookingRequest;
import com.saurav.dto.BookingResponse;
import com.saurav.entity.BookedSeat;
import com.saurav.entity.Booking;
import com.saurav.entity.Show;
import com.saurav.repository.BookedSeatRepository;
import com.saurav.repository.BookingRepository;
import com.saurav.repository.ShowRepository;

import exception.ShowNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookedSeatRepository bookedSeatRepository;

    @Autowired
    private ShowRepository showRepository;

    @Transactional
    public BookingResponse bookTickets(BookingRequest request) {

        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new ShowNotFoundException("Show not found "+ + request.getShowId()));

        List<BookedSeat> alreadyBooked =
                bookedSeatRepository.findByShowIdAndSeatNumberIn(
                        request.getShowId(),
                        request.getSeats());
        
        if (!alreadyBooked.isEmpty()) {

            List<String> booked = alreadyBooked.stream()
                    .map(BookedSeat::getSeatNumber)
                    .toList();

            throw new RuntimeException("Seats already booked: " + booked);
        }
        
        Booking booking = new Booking();
        booking.setUserName(request.getUserName());
        booking.setBookingTime(LocalDateTime.now());
        booking.setShow(show);

        booking = bookingRepository.save(booking);
        
        List<String> confirmedSeats = new ArrayList<>();

        for(String seat : request.getSeats()) {

            BookedSeat bs = new BookedSeat();
            bs.setSeatNumber(seat);
            bs.setShowId(request.getShowId());
            bs.setBooking(booking);

            bookedSeatRepository.save(bs);
            confirmedSeats.add(seat);
        }

        //return "Booking Confirmed";
        return new BookingResponse(booking.getId(), confirmedSeats);
    }
}