package com.example.stade.service;

import com.example.stade.dtos.MatchCreateDTO;
import com.example.stade.dtos.MatchFootDTO;

import java.util.List;

public interface MatchService {
    MatchCreateDTO saveMatch (MatchCreateDTO matchFootDTO);
    List<MatchFootDTO> getAllMatch();
    MatchFootDTO getMatch(Long matchId);
}
