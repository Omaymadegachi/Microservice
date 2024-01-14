package com.example.stade.dtos;

import com.example.stade.enums.JoueurRole;
import lombok.Data;


@Data
public class JoueurMatchDTO extends  PersonneDTO{
    private JoueurRole joueurRole;
    private long equipe_id;
    private int numero;
    private String etat;
}
