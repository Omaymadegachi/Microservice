package com.example.match.web;

import com.example.match.dtos.StadeDTO;
import com.example.match.service.StadeServieImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StadeRestController {
    private StadeServieImpl stadeServie;

    @PostMapping("/stades/")
    public StadeDTO saveJoueur(@RequestBody StadeDTO request ) {
        // Récupérer  les donneer à partir de l'objet request
        return stadeServie.saveStade(request);
    }
    @GetMapping("/stades/{id}")
    public StadeDTO getJoueur(@PathVariable(name = "id") Long stadeId) {
        // Récupérer  les donneer à partir de l'objet request
        return stadeServie.getStade(stadeId);
    }
    @GetMapping("/stades/")
    public List<StadeDTO> listJoueur(){
        return stadeServie.getStadeList();
    }
}
