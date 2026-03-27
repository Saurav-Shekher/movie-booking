package com.saurav.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.dto.TheatreResponseDTO;
import com.saurav.service.ShowService;

@RestController
@RequestMapping("/movies")
public class MovieController {

@Autowired
ShowService showService;

@GetMapping("/shows")
public List<TheatreResponseDTO> browseTheatres(
@RequestParam String movieName,
@RequestParam String city,
@RequestParam(required = false) String date,
@RequestParam(required = false) String showTime){

	LocalDate showDate = null;
	LocalTime time = null;
	
	if (date != null && !date.isBlank()) {
		showDate = LocalDate.parse(date);
    }

    if (showTime != null && !showTime.isBlank()) {
        time = LocalTime.parse(showTime);
    }

    return showService.getTheatres(movieName, city, showDate,time);
}
}