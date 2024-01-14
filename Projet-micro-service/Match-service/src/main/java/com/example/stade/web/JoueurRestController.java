package com.example.stade.web;

import com.example.stade.dtos.JoueurCreateDTO;
import com.example.stade.service.JoueurServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class JoueurRestController {
    private JoueurServiceImpl joueurService;

    @PostMapping("/joueurs/")
    public JoueurCreateDTO saveJoueur(@RequestBody JoueurCreateDTO request ) {
        // Récupérer  les donneer à partir de l'objet request
        return joueurService.saveJoueur(request);
    }
    @GetMapping("/joueurs/{id}")
    public JoueurCreateDTO getJoueur(@PathVariable(name = "id") Long joueurId) {
        // Récupérer  les donneer à partir de l'objet request
        return joueurService.getJoueur(joueurId);
    }
    @GetMapping("/joueurs/")
    public List<JoueurCreateDTO> listJoueur(){
        return joueurService.getJoueurList();
    }
    @GetMapping("/joueurs/equipe/{id}")
    public List<JoueurCreateDTO> listJoueurByEquipe(@PathVariable(name = "id") Long equipeId){
        return joueurService.getJoueurListByEquipe(equipeId);
    }
}
