package com.example.stade.mapper;

import com.example.stade.dtos.*;
import com.example.stade.entities.Arbitre;
import com.example.stade.entities.Equipe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipeMapper {
    EntraineurMapper entraineurMapper =new EntraineurMapper();
    JoueurMapper joueurMapper=new JoueurMapper();
    public EquipeDTO fromEquipe(Equipe equipe){
        EquipeDTO equipeDTO =new EquipeDTO();
        BeanUtils.copyProperties(equipe,equipeDTO);
        //equipeDTO.setEntraineurDTO(entraineurMapper.fromEntraineur((equipe.getEntraineur())));
        return equipeDTO;
    }
    public Equipe fromEquipeDTO(EquipeDTO equipeDTO){
        Equipe equipe=new Equipe();
        BeanUtils.copyProperties(equipeDTO,equipe);
        //equipe.setEntraineur(entraineurMapper.fromEntraineurDTO((equipeDTO.getEntraineurDTO())));
        return equipe;
    }
    public EquipeCompletDTO fromEquipeComplet(Equipe equipe){
        EquipeCompletDTO equipeCompletDTO =new EquipeCompletDTO();
        //System.out.println(equipe);
        BeanUtils.copyProperties(equipe,equipeCompletDTO);
        equipeCompletDTO.setEntraineurDTO(entraineurMapper.fromEntraineur(equipe.getEntraineur()));
        equipeCompletDTO.setJoueurListDTO(equipe.getJoueurList().stream()
                .map(joueur -> joueurMapper.fromJoueur(joueur))
                .collect(Collectors.toList()));
        return equipeCompletDTO;
    }
    public Equipe fromEquipeCompletDTO(EquipeCompletDTO equipeCompletDTO){
        Equipe equipe =new Equipe();
        BeanUtils.copyProperties(equipeCompletDTO,equipe);
        equipe.setEntraineur(entraineurMapper.fromEntraineurDTO(equipeCompletDTO.getEntraineurDTO()));
        equipe.setJoueurList(equipeCompletDTO.getJoueurListDTO().stream()
                .map(joueurDTO -> joueurMapper.fromJoueurDTO(joueurDTO))
                .collect(Collectors.toList()));
        return equipe;
    }
    //////////////////////////////////////////
    public EquipeMatchDTO fromEquipeMatch(Equipe equipe){
        EquipeMatchDTO equipeMatchDTO =new EquipeMatchDTO();
        //System.out.println(equipe);
        BeanUtils.copyProperties(equipe,equipeMatchDTO);
        equipeMatchDTO.setEntraineurDTO(entraineurMapper.fromEntraineur(equipe.getEntraineur()));
        equipeMatchDTO.setJoueurMatchDTOList(equipe.getJoueurList().stream()
                .map(joueur -> joueurMapper.fromMatchJoueur(joueur))
                .collect(Collectors.toList()));
        return equipeMatchDTO;
    }
    public Equipe fromEquipeMatchDTO(EquipeMatchDTO equipeMatchDTO){
        Equipe equipe =new Equipe();
        BeanUtils.copyProperties(equipeMatchDTO,equipe);
        equipe.setEntraineur(entraineurMapper.fromEntraineurDTO(equipeMatchDTO.getEntraineurDTO()));
        equipe.setJoueurList(equipeMatchDTO.getJoueurMatchDTOList().stream()
                .map(joueurDTO -> joueurMapper.fromJoueurMatchDTO(joueurDTO))
                .collect(Collectors.toList()));
        return equipe;
    }
    /////
    public EquipeListeDTO fromEquipeListe(Equipe equipe){
        EquipeListeDTO equipeListeDTO =new EquipeListeDTO();
        BeanUtils.copyProperties(equipe,equipeListeDTO);
        equipeListeDTO.setEntraineurDTO(entraineurMapper.fromEntraineur(equipe.getEntraineur()));
        equipeListeDTO.setJoueurListDTO(equipe.getJoueurList().stream()
                .map(joueur -> joueurMapper.fromJoueur(joueur))
                .collect(Collectors.toList()));
        return equipeListeDTO;
    }
    public Equipe fromEquipeListeDTO(EquipeListeDTO equipeListeDTO){
        Equipe equipe =new Equipe();
        BeanUtils.copyProperties(equipeListeDTO,equipe);
        equipe.setEntraineur(entraineurMapper.fromEntraineurDTO(equipeListeDTO.getEntraineurDTO()));
        equipe.setJoueurList(equipeListeDTO.getJoueurListDTO().stream()
                .map(joueurDTO -> joueurMapper.fromJoueurDTO(joueurDTO))
                .collect(Collectors.toList()));
        return equipe;
    }
}
