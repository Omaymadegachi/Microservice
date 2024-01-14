package com.example.stade.dtos;

import com.example.stade.entities.Equipe;
import com.example.stade.entities.Personne;
import jakarta.persistence.*;
import lombok.*;

@Data
public class EntraineurDTO extends PersonneDTO {
    private long equipe_id;
}
