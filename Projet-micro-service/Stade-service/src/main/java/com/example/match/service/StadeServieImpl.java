package com.example.match.service;

import com.example.match.dtos.StadeDTO;
import com.example.match.entities.Stade;
import com.example.match.mapper.StadeMapper;
import com.example.match.repository.StadeRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class StadeServieImpl implements StadeServie {
    private StadeRespository stadeRespository;
    private StadeMapper stadeMapper;
    @Override
    public StadeDTO saveStade(StadeDTO stadeDTO) {
        Stade saveStade=stadeRespository.save(stadeMapper.fromStadeDTO(stadeDTO));
        return stadeMapper.fromStade(saveStade);
    }
    @Override
    public StadeDTO getStade(Long StadeId) {
        Stade stade=stadeRespository.findById(StadeId).orElse(null);
        if(stade==null){
            throw new RuntimeException();
        }
        return stadeMapper.fromStade(stade);
    }
    public List<StadeDTO> getStadeList() {
        List<Stade> stadeList = stadeRespository.findAll();
        return stadeList.stream()
                .map(stade -> stadeMapper.fromStade(stade))
                .collect(Collectors.toList());
    }
}
