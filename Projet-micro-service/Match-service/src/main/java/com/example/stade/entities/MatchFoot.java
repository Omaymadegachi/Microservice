package com.example.stade.entities;

import com.example.stade.model.Stade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@Builder
@Data
public class MatchFoot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private LocalDate dateMatch;
    private int journee;
    private int capacite;
    @ManyToOne
    private Arbitre arbitre;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Equipe> equipes=new ArrayList<>();
    @Transient
    // Car Customer n'est pas une entités JPA elle va
    // ingorer l'attrubut càd il ne sera pas dans la base de donnee
    private Stade stade;
    private Long stadeId;
}
