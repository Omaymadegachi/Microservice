package com.example.stade.web;

import com.example.stade.dtos.EquipeCompletDTO;
import com.example.stade.dtos.EquipeDTO;
import com.example.stade.service.EquipeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeResController {
    private EquipeServiceImpl equipeService;

    @PostMapping("/equipes/")
    public EquipeDTO saveEquipe(@RequestBody EquipeDTO request ) {
        // Récupérer  les donneer à partir de l'objet request
        return equipeService.saveEquipe(request);
    }

    @GetMapping("/equipes/{id}")
    public EquipeCompletDTO getEquipe(@PathVariable(name = "id") Long equipeId) {
        // Récupérer  les donneer à partir de l'objet request
        return equipeService.getEquipeById(equipeId);
    }

    @GetMapping("/equipes/")
    public List<EquipeDTO> listEquipe(){
        return equipeService.getEquipesList();
    }

}
