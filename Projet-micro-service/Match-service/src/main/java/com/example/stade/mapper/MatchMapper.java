package com.example.stade.mapper;

import com.example.stade.dtos.EquipeDTO;
import com.example.stade.dtos.MatchCreateDTO;
import com.example.stade.dtos.MatchFootDTO;
import com.example.stade.entities.Entraineur;
import com.example.stade.entities.Equipe;
import com.example.stade.entities.MatchFoot;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MatchMapper {
    ArbitreMapper arbitreMapper =new ArbitreMapper();
    EquipeMapper equipeMapper=new EquipeMapper();
    public MatchFootDTO fromMatchFoot(MatchFoot matchFoot){
        MatchFootDTO matchFootDTO =new MatchFootDTO();
        BeanUtils.copyProperties(matchFoot,matchFootDTO);
        matchFootDTO.setArbitreDTO(arbitreMapper.fromArbitre((matchFoot.getArbitre())));
        matchFootDTO.setEquipeMatchDTOS(matchFoot.getEquipes().stream()
                .map(equipe -> equipeMapper.fromEquipeMatch(equipe))
                .collect(Collectors.toList()));
        return matchFootDTO;
    }
    public MatchFoot fromMatchFootDTO(MatchFootDTO matchFootDTO){
        MatchFoot matchFoot=new MatchFoot();
        BeanUtils.copyProperties(matchFootDTO,matchFoot);
        matchFoot.setArbitre(arbitreMapper.fromArbitreDTO(matchFootDTO.getArbitreDTO()));
        matchFoot.setEquipes(matchFootDTO.getEquipeMatchDTOS().stream()
                .map(equipeDTO -> equipeMapper.fromEquipeMatchDTO(equipeDTO))
                .collect(Collectors.toList()));
        return matchFoot;
    }
    public MatchCreateDTO fromMatchCreate(MatchFoot matchFoot){
        MatchCreateDTO matchCreateDTO =new MatchCreateDTO();
        BeanUtils.copyProperties(matchFoot,matchCreateDTO);
        return matchCreateDTO;
    }
    public MatchFoot fromMatchCreateDTO(MatchCreateDTO matchCreateDTO){
        MatchFoot matchFoot=new MatchFoot();
        BeanUtils.copyProperties(matchCreateDTO,matchFoot);
        return matchFoot;
    }

    public MatchFoot fromEntraineur(Entraineur entraineur){
        if (entraineur == null) {
            return null; // Or handle the case appropriately
        }
        MatchFoot matchFoot =new MatchFoot();
        BeanUtils.copyProperties(entraineur,matchFoot);
        return matchFoot;
    }

}
