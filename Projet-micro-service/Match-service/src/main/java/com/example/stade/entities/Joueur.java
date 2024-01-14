package com.example.stade.entities;

import com.example.stade.enums.JoueurRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@DiscriminatorValue("JOUEUR")
//@Builder
@Data
public class Joueur extends Personne{
    @Enumerated(EnumType.STRING)
    private JoueurRole joueurRole;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    private int numero;
    private String etat;
}
