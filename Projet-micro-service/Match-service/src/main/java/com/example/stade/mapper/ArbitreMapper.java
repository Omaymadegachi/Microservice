package com.example.stade.mapper;

import com.example.stade.dtos.ArbitreDTO;
import com.example.stade.dtos.EntraineurDTO;
import com.example.stade.entities.Arbitre;
import com.example.stade.entities.Entraineur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbitreMapper {
    public ArbitreDTO fromArbitre(Arbitre arbitre){
        ArbitreDTO arbitreDTO =new ArbitreDTO();
        BeanUtils.copyProperties(arbitre,arbitreDTO);
        return arbitreDTO;
    }
    public Arbitre fromArbitreDTO(ArbitreDTO arbitreDTO){
        Arbitre arbitre=new Arbitre();
        BeanUtils.copyProperties(arbitreDTO,arbitre);
        return arbitre;
    }
    public List<ArbitreDTO> fromArbitres(List<Arbitre> arbitres){
        return arbitres.stream().map(this::fromArbitre).toList();
    }
}
