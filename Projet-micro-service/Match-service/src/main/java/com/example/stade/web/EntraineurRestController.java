package com.example.stade.web;

import com.example.stade.dtos.EntraineurDTO;
import com.example.stade.dtos.EquipeDTO;
import com.example.stade.service.EntraineurServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EntraineurRestController {
    private EntraineurServiceImpl entraineurService;
    @PostMapping("/entraineurs/")
    public EntraineurDTO saveEntraineur(@RequestBody EntraineurDTO request ) {
        // Récupérer  les donneer à partir de l'objet request
        return entraineurService.saveEntaineur(request);
    }

    @GetMapping("/entraineurs/")
    public List<EntraineurDTO> getAllEntraineurs(){
        return entraineurService.getAllEntraineurs();
    }

    @GetMapping("/entraineurs/{id}")
    public EntraineurDTO getEntraineur(@PathVariable("id") Long IdEntraineur) {
        return entraineurService.getEntraineurById(IdEntraineur);
    }

    @GetMapping("/entraineurs/equipe/{id}")
    public EntraineurDTO getEntraineurByEquipeId(@PathVariable("id") Long equipeId) {
        return entraineurService.getEntraineurByEquipeId(equipeId);
    }
}
