package com.saurav.dto;

import java.util.List;

public class TheatreResponseDTO {

    private String theatreName;
    private List<ShowDTO> shows;
    
    
	protected TheatreResponseDTO() {
		super();
		
	}
	
	public TheatreResponseDTO(String theatreName, List<ShowDTO> shows) {
		super();
		this.theatreName = theatreName;
		this.shows = shows;
	}

	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}

    
}