package com.example.stade.repository;

import com.example.stade.entities.Arbitre;
import com.example.stade.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur,Long> {
    List<Joueur> findByEquipeId(Long equipeId);
}
