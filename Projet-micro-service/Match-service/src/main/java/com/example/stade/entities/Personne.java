package com.example.stade.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@Builder
@Data
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS) //pour l'heritage
//@DiscriminatorColumn(name = "TYPE",length = 4,discriminatorType = DiscriminatorType.STRING)
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private  String firstName;
    private String lastName;
    private  String nation;
    private  String picture;
}
