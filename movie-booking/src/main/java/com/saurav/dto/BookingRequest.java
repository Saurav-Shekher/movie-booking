package com.saurav.dto;

import java.util.List;

public class BookingRequest {

    private Long showId;

    private String userName;

    private List<String> seats;

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
    
    
}