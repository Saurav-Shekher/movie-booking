package com.saurav.dto;

import java.util.List;

public class BookingResponse {

    private Long bookingId;
    private List<String> confirmedSeats;

    public BookingResponse(Long bookingId, List<String> confirmedSeats) {
        this.bookingId = bookingId;
        this.confirmedSeats = confirmedSeats;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public List<String> getConfirmedSeats() {
        return confirmedSeats;
    }
}