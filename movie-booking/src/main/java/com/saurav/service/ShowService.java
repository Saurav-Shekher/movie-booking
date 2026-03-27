package com.saurav.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.dto.ShowDTO;
import com.saurav.dto.TheatreResponseDTO;
import com.saurav.repository.ShowRepository;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    
    public List<TheatreResponseDTO> getTheatres(String movieName, String city, LocalDate date, LocalTime time) {

        List<Object[]> rows = showRepository.findTheatresByMovieCityDate(movieName, city, date, time);

        Map<String, List<ShowDTO>> theatreMap = new HashMap<>();

        for (Object[] row : rows) {

            Long showId = (Long) row[0];
            String theatreName = (String) row[1];
            LocalTime showTime = (LocalTime) row[2];

            ShowDTO showDTO = new ShowDTO(showId, showTime.toString());

            theatreMap.computeIfAbsent(theatreName, k -> new ArrayList<>()).add(showDTO);
        }

        List<TheatreResponseDTO> result = new ArrayList<>();

        for (Map.Entry<String, List<ShowDTO>> entry : theatreMap.entrySet()) {
            result.add(new TheatreResponseDTO(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}