package com.example.stade.service;

import com.example.stade.dtos.EntraineurDTO;
import com.example.stade.entities.Entraineur;
import com.example.stade.entities.Equipe;
import com.example.stade.mapper.EntraineurMapper;
import com.example.stade.repository.EntraineurRepository;
import com.example.stade.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EntraineurServiceImpl implements EntraineurService {
    private EntraineurRepository entraineurRepository;
    private EntraineurMapper entraineurMapper;
    private EquipeRepository equipeRepository;
    @Override
    public EntraineurDTO saveEntaineur(EntraineurDTO entraineurDTO) {
        Entraineur entraineur=entraineurMapper.fromEntraineurDTO(entraineurDTO);
        Entraineur savedEntraineur=entraineurRepository.save(entraineur);
        return entraineurMapper.fromEntraineur(savedEntraineur);
    }

    @Override
    public EntraineurDTO getEntraineurById(Long IdEntraineur) {
        Entraineur entraineur=entraineurRepository.findById(IdEntraineur).get();
        return entraineurMapper.fromEntraineur(entraineur);
    }

    @Override
    public List<EntraineurDTO> getAllEntraineurs() {
        List<Entraineur> entraineurs=entraineurRepository.findAll();
        return entraineurs.stream()
                .map(entraineur -> entraineurMapper.fromEntraineur(entraineur))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public EntraineurDTO getEntraineurByEquipeId(Long equipeId) {
        Equipe equipe=equipeRepository.findById(equipeId).get();
        Entraineur entraineur=entraineurRepository.findByEquipe_Id(equipe.getId());
        return entraineurMapper.fromEntraineur(entraineur);
    }
}
