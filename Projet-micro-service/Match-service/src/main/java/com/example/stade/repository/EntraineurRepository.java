package com.example.stade.repository;

import com.example.stade.entities.Entraineur;
import com.example.stade.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntraineurRepository extends JpaRepository<Entraineur,Long> {
    Entraineur findByEquipe_Id(int equipe_id);
}
