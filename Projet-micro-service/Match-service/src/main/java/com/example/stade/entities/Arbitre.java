package com.example.stade.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@DiscriminatorValue("ARBITRE")
//@Builder
@Data
public class Arbitre extends  Personne{
    @OneToMany(mappedBy = "arbitre",fetch = FetchType.LAZY)
    private List<MatchFoot> matchFoots;
}
