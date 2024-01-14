package com.example.stade.dtos;

import lombok.Data;

import java.util.List;


@Data
public class EquipeListeDTO {
    private int id;
    private  String name;
    private List<JoueurCreateDTO> joueurListDTO;
    private EntraineurDTO entraineurDTO;
}
