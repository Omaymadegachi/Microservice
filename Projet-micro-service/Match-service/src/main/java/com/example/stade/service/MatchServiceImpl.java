package com.example.stade.service;

import com.example.stade.clients.StadeRestClient;
import com.example.stade.dtos.EquipeCompletDTO;
import com.example.stade.dtos.EquipeMatchDTO;
import com.example.stade.dtos.MatchCreateDTO;
import com.example.stade.dtos.MatchFootDTO;
import com.example.stade.entities.*;
import com.example.stade.mapper.EquipeMapper;
import com.example.stade.mapper.JoueurMapper;
import com.example.stade.mapper.MatchMapper;
import com.example.stade.model.Stade;
import com.example.stade.repository.ArbitreRepository;
import com.example.stade.repository.EquipeRepository;
import com.example.stade.repository.JoueurRepository;
import com.example.stade.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private ArbitreRepository arbitreRepository;
    private EquipeRepository equipeRepository;
    private MatchRepository matchRepository;
    private MatchMapper matchMapper;
    private EquipeMapper equipeMapper;
    private StadeRestClient stadeRestClient;
    @Override
    public MatchCreateDTO saveMatch(MatchCreateDTO matchCreateDTO) {
        MatchFoot matchFoot=matchMapper.fromMatchCreateDTO(matchCreateDTO);
        Equipe equipeOne=equipeRepository.findById(matchCreateDTO.getEquipeOneId()).orElse(null);
        if(equipeOne==null){
            throw new RuntimeException();
        }
        Equipe equipeTow=equipeRepository.findById(matchCreateDTO.getEquipeTowId()).orElse(null);
        if(equipeTow==null){
            throw new RuntimeException();
        }
        List<Equipe> equipeList=new ArrayList<>();
        equipeList.add(equipeOne);
        equipeList.add(equipeTow);
        matchFoot.setEquipes(equipeList);
        Arbitre arbitre=arbitreRepository.findById(matchCreateDTO.getArbitreId()).orElse(null);
        if(arbitre==null){
            throw new RuntimeException();
        }
        matchFoot.setArbitre(arbitre);
        Stade stade=stadeRestClient.findStadeById(matchCreateDTO.getStadeId());
        if(stade==null){
            throw new RuntimeException();
        }
        matchFoot.setStade(stade);
        MatchFoot matchFootSaved =matchRepository.save(matchFoot);
        return matchMapper.fromMatchCreate(matchFootSaved);
    }

    @Override
    public List<MatchFootDTO> getAllMatch() {
        List<MatchFoot> matchFootList = matchRepository.findAll();
        List<EquipeMatchDTO>equipeCompletDTOList= new ArrayList<>();
        return matchFootList.stream()
                .map(matchFoot -> {
                    Arbitre arbitre=arbitreRepository.findById(matchFoot.getArbitre().getId()).orElse(null);
                    if(arbitre==null){
                        throw new RuntimeException();
                    }
                    matchFoot.setArbitre(arbitre);
                    List<Equipe> equipes = matchFoot.getEquipes();
                    equipes.stream().map(equipe -> {
                        equipeCompletDTOList.add(equipeMapper.fromEquipeMatch(equipeRepository.findById((long) equipe.getId()).orElse(null)));
                        return equipe;
                    }).toList();
                    Stade stade=stadeRestClient.findStadeById(matchFoot.getStadeId());
                    if(stade==null){
                        throw new RuntimeException();
                    }
                    matchFoot.setStade(stade);
                    MatchFootDTO matchDTO=matchMapper.fromMatchFoot(matchFoot);
                    matchDTO.setEquipeMatchDTOS(equipeCompletDTOList);
                    return matchDTO;
                }).toList();

    }

    @Override
    public MatchFootDTO getMatch(Long matchId) {
        MatchFoot matchFoot = matchRepository.findById(matchId).orElse(null);
        List<EquipeMatchDTO>equipeMatchDTOList= new ArrayList<>();
        Arbitre arbitre=arbitreRepository.findById(matchFoot.getArbitre().getId()).orElse(null);
        if(arbitre==null){
            throw new RuntimeException();
        }
        matchFoot.setArbitre(arbitre);
        List<Equipe> equipes = matchFoot.getEquipes();
        equipes.stream().map(equipe -> {
            equipeMatchDTOList.add(equipeMapper.fromEquipeMatch(equipeRepository.findById((long) equipe.getId()).orElse(null)));
            return equipe;
        }).toList();
        Stade stade=stadeRestClient.findStadeById(matchFoot.getStadeId());
        if(stade==null){
            throw new RuntimeException();
        }
        matchFoot.setStade(stade);
        MatchFootDTO matchDTO=matchMapper.fromMatchFoot(matchFoot);
        matchDTO.setEquipeMatchDTOS(equipeMatchDTOList);
        return matchDTO;
    }
}
