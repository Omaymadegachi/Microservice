package com.example.stade.mapper;

import com.example.stade.dtos.JoueurCreateDTO;
import com.example.stade.dtos.JoueurMatchDTO;
import com.example.stade.entities.Joueur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class JoueurMapper {
    public JoueurCreateDTO fromJoueur(Joueur joueur){
        JoueurCreateDTO joueurCreateDTO =new JoueurCreateDTO();
        BeanUtils.copyProperties(joueur, joueurCreateDTO);
        return joueurCreateDTO;
    }
    public Joueur fromJoueurDTO(JoueurCreateDTO joueurCreateDTO){
        Joueur joueur=new Joueur();
        BeanUtils.copyProperties(joueurCreateDTO,joueur);
        return joueur;
    }
    public JoueurMatchDTO fromMatchJoueur(Joueur joueur){
        JoueurMatchDTO joueurMatchDTO =new JoueurMatchDTO();
        BeanUtils.copyProperties(joueur, joueurMatchDTO);
        return joueurMatchDTO;
    }
    public Joueur fromJoueurMatchDTO(JoueurMatchDTO joueurMatchDTO){
        Joueur joueur=new Joueur();
        BeanUtils.copyProperties(joueurMatchDTO,joueur);
        return joueur;
    }
}
