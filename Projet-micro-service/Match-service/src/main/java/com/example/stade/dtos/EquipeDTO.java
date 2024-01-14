package com.example.stade.dtos;

import lombok.*;

import java.util.List;


@Data
public class EquipeDTO {
    private int id;
    private  String name;
    private  String picture;
    @Getter
    @Setter
    private Long entraineurId;

}
