package com.example.match.mapper;

import com.example.match.dtos.StadeDTO;
import com.example.match.entities.Stade;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StadeMapper {
    public StadeDTO fromStade(Stade stade){
        StadeDTO stadeDTO =new StadeDTO();
        BeanUtils.copyProperties(stade,stadeDTO);
        return stadeDTO;
    }
    public Stade fromStadeDTO(StadeDTO stadeDTO){
        Stade stade=new Stade();
        BeanUtils.copyProperties(stadeDTO,stade);
        return stade;
    }
}
