package com.example.stade.dtos;

import com.example.stade.model.Stade;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class MatchFootDTO {
    private  int id;
    private LocalDate dateMatch;
    private int journee;
    private int capacite;
    private ArbitreDTO arbitreDTO;
    private long equipeOneId;
    private long equipeTowId;
    private List<EquipeMatchDTO> equipeMatchDTOS;
    private Stade stade;
}
