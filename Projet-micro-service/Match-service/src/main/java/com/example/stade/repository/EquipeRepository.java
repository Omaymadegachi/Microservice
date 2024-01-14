package com.example.stade.repository;

import com.example.stade.entities.Equipe;
import com.example.stade.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
