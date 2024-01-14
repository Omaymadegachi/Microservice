package com.example.match.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
public class Stade {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private  int capacite;
}
