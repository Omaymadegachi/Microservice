package com.example.stade.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@Builder
@Data
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    @OneToMany(mappedBy = "equipe",fetch = FetchType.LAZY)
    private List<Joueur> joueurList;
    @OneToOne
    @JoinColumn(name = "entraineur_id")
    private Entraineur entraineur;
    @ManyToMany(mappedBy = "equipes" ,fetch = FetchType.EAGER)
    private List<MatchFoot> matchFoots =new ArrayList<>();
    private  int points;
    private  int victoire;
    private  int nul;
    private int defaite;
    private int buts;
    private  int butsContre;
    private  String picture;
}
