package com.example.match.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
public class StadeDTO {
    private  Long id;
    private String name;
    private  int capacite;
}
