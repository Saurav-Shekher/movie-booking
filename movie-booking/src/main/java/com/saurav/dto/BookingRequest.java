package com.saurav.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookingRequest {

    private Long showId;

    private String userName;

    private List<String> seats;

	
    
}