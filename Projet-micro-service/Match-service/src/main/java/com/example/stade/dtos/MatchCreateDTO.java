package com.example.stade.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MatchCreateDTO {
    private  int id;
    private LocalDate dateMatch;
    private int journee;
    private int capacite;
    private long arbitreId;
    private long equipeOneId;
    private long equipeTowId;
    private long stadeId;
}
