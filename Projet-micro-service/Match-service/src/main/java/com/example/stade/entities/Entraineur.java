package com.example.stade.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@DiscriminatorValue("ENTRAINEUR")
//@Builder
@Data
public class Entraineur extends Personne{
    @OneToOne(mappedBy = "entraineur")
    private Equipe equipe;
}
