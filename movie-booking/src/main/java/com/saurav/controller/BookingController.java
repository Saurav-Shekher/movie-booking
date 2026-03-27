package com.saurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.dto.BookingRequest;
import com.saurav.dto.BookingResponse;
import com.saurav.service.BookingService;


@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTickets(@RequestBody BookingRequest request) {

        return bookingService.bookTickets(request);
    }
    
    
}