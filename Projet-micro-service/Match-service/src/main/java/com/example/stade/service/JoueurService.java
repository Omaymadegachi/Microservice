package com.example.stade.service;

import com.example.stade.dtos.JoueurCreateDTO;
import com.example.stade.enums.JoueurRole;

import java.util.List;

public interface JoueurService {
    JoueurCreateDTO saveJoueur(JoueurCreateDTO joueurCreateDTO);
    JoueurCreateDTO getJoueur(Long joueurId);
    List<JoueurCreateDTO> getJoueurList();
    List<JoueurCreateDTO> getJoueurListByEquipe(Long equipeId);
}
