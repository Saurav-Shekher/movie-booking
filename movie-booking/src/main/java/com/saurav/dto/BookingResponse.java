package com.saurav.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private List<String> confirmedSeats;

}