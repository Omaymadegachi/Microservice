package com.example.stade.service;

import com.example.stade.dtos.EquipeCompletDTO;
import com.example.stade.dtos.EquipeDTO;
import com.example.stade.entities.Entraineur;
import com.example.stade.entities.Equipe;
import com.example.stade.entities.Joueur;
import com.example.stade.mapper.EquipeMapper;
import com.example.stade.repository.EntraineurRepository;
import com.example.stade.repository.EquipeRepository;
import com.example.stade.repository.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements EquipeService {
    private EquipeMapper equipeMapper;
    private EquipeRepository equipeRepository;
    private EntraineurRepository entraineurRepository;
    private JoueurRepository joueurRepository;
    @Override
    public EquipeDTO saveEquipe(EquipeDTO equipeDTO) {
        Equipe equipe = equipeMapper.fromEquipeDTO(equipeDTO);

        // Fetch and set the Entraineur
        if (equipeDTO.getEntraineurId() != null) {
            Entraineur entraineur = entraineurRepository.findById(equipeDTO.getEntraineurId())
                    .orElseThrow(() -> new RuntimeException("Entraineur not found"));
            equipe.setEntraineur(entraineur);
        }

        Equipe savedEquipe = equipeRepository.save(equipe);
        return equipeMapper.fromEquipe(savedEquipe);
    }

    @Override
    public EquipeCompletDTO getEquipeById(Long equipdeID) {
        Equipe equipe=equipeRepository.findById(equipdeID).orElse(null);
        List<Joueur> joueurList=joueurRepository.findByEquipeId((long) equipe.getId());
        Entraineur entraineur=entraineurRepository.findByEquipe_Id(equipe.getId());
        equipe.setJoueurList(joueurList);
        equipe.setEntraineur(entraineur);
        return equipeMapper.fromEquipeComplet(equipe);
    }

    @Override
    public List<EquipeDTO> getEquipesList() {
        List<Equipe> equipeList=equipeRepository.findAll();
        return equipeList.stream()
                .map(equipe -> equipeMapper.fromEquipe(equipe))
                .collect(Collectors.toList());
    }

}
