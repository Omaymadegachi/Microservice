package com.example.stade.service;

import com.example.stade.dtos.JoueurCreateDTO;
import com.example.stade.entities.Equipe;
import com.example.stade.entities.Joueur;
import com.example.stade.enums.JoueurRole;
import com.example.stade.mapper.JoueurMapper;
import com.example.stade.repository.EquipeRepository;
import com.example.stade.repository.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JoueurServiceImpl implements JoueurService {
    private JoueurRepository joueurRepository;
    private EquipeRepository equipeRepository;
    private JoueurMapper joueurMapper;
    @Override
    public JoueurCreateDTO saveJoueur(JoueurCreateDTO joueurCreateDTO) {
        Joueur joueur=joueurMapper.fromJoueurDTO(joueurCreateDTO);
        Equipe equipe=equipeRepository.findById(joueurCreateDTO.getEquipe_id()).orElse(null);
        if(equipe==null){
            throw new RuntimeException();
        }
        joueur.setEquipe(equipe);
        Joueur savedJoueur=joueurRepository.save(joueur);
        return joueurMapper.fromJoueur(savedJoueur);
    }

    @Override
    public JoueurCreateDTO getJoueur(Long joueurId) {
        Joueur joueur=joueurRepository.findById(joueurId).orElse(null);
        return joueurMapper.fromJoueur(joueur);
    }

    @Override
    public List<JoueurCreateDTO> getJoueurList() {
        List<Joueur> joueurList = joueurRepository.findAll();
        return joueurList.stream()
                .map(joueur -> joueurMapper.fromJoueur(joueur))
                .collect(Collectors.toList());
    }

    @Override
    public List<JoueurCreateDTO> getJoueurListByEquipe(Long equipeId) {
        List<Joueur> joueurList = joueurRepository.findByEquipeId(equipeId);
        return joueurList.stream()
                .map(joueur -> joueurMapper.fromJoueur(joueur))
                .collect(Collectors.toList());
    }

}
