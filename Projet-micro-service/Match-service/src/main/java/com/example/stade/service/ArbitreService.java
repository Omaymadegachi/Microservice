package com.example.stade.service;

import com.example.stade.dtos.ArbitreDTO;

import java.util.List;

public interface ArbitreService {
    ArbitreDTO saveArbitre(ArbitreDTO arbitreDTO);

    ArbitreDTO getArbitreById(Long id);

    List<ArbitreDTO> getAllArbitres();
}
