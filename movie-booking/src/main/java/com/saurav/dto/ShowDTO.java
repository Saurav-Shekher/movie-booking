package com.saurav.dto;

public class ShowDTO {

    private Long showId;
    private String showTime;
    
    
	protected ShowDTO() {
		super();
		
	}

	public ShowDTO(Long showId, String showTime) {
		super();
		this.showId = showId;
		this.showTime = showTime;
	}
	
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
    
    

}