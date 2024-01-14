package com.example.stade.service;

import com.example.stade.dtos.ArbitreDTO;
import com.example.stade.entities.Arbitre;
import com.example.stade.mapper.ArbitreMapper;
import com.example.stade.repository.ArbitreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ArbitreServiceImpl implements ArbitreService {
    private ArbitreRepository arbitreRepository;
    private ArbitreMapper arbitreMapper;
    @Override
    public ArbitreDTO saveArbitre(ArbitreDTO arbitreDTO) {
        Arbitre savedarbitre=arbitreRepository.save(arbitreMapper.fromArbitreDTO(arbitreDTO));
        return arbitreMapper.fromArbitre(savedarbitre);
    }

    @Override
    public ArbitreDTO getArbitreById(Long id) {
        return arbitreRepository.findById(id)
                .map(arbitreMapper::fromArbitre)
                .orElseThrow(() -> new EntityNotFoundException("Arbitre not found with id: " + id));
    }

    @Override
    public List<ArbitreDTO> getAllArbitres() {
        return arbitreMapper.fromArbitres(arbitreRepository.findAll());
    }
}
