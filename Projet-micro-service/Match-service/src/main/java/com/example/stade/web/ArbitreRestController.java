package com.example.stade.web;

import com.example.stade.dtos.ArbitreDTO;
import com.example.stade.dtos.EntraineurDTO;
import com.example.stade.service.ArbitreServiceImpl;
import com.example.stade.service.EntraineurServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ArbitreRestController {
    private ArbitreServiceImpl arbitreService;
    @PostMapping("/arbitres/")
    public ArbitreDTO addArbitre(@RequestBody ArbitreDTO arbitreDTO) {
        return arbitreService.saveArbitre(arbitreDTO);
    }

    @GetMapping("/arbitres/")
    public Iterable<ArbitreDTO> getAllArbitres() {
        return arbitreService.getAllArbitres();
    }

    @GetMapping("/arbitres/{id}")
    public ArbitreDTO getArbitreById(@PathVariable Long id) {
        return arbitreService.getArbitreById(id);
    }
}
