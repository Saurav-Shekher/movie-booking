package com.saurav.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TheatreResponseDTO {

    private String theatreName;
    private List<ShowDTO> shows;
    
}