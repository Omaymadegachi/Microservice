package com.example.stade.mapper;

import com.example.stade.dtos.EntraineurDTO;
import com.example.stade.entities.Entraineur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EntraineurMapper {
    public EntraineurDTO fromEntraineur(Entraineur entraineur){
        if (entraineur == null) {
            return null; // Or handle the case appropriately
        }
        EntraineurDTO entraineurDTO =new EntraineurDTO();
        BeanUtils.copyProperties(entraineur,entraineurDTO);
        return entraineurDTO;
    }
    public Entraineur fromEntraineurDTO(EntraineurDTO entraineurDTO){
        Entraineur entraineur=new Entraineur();
        BeanUtils.copyProperties(entraineurDTO,entraineur);
        return entraineur;
    }
}
