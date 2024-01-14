package com.example.stade.web;

import com.example.stade.dtos.MatchCreateDTO;
import com.example.stade.dtos.MatchFootDTO;
import com.example.stade.service.MatchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatchRestController {
    private MatchServiceImpl matchService;
    @PostMapping("/matches/")
    public MatchCreateDTO saveEntraineur(@RequestBody MatchCreateDTO request ) {
        // Récupérer  les donneer à partir de l'objet request
        return matchService.saveMatch(request);
    }

    @GetMapping("/matches/")
    public List<MatchFootDTO> getAllMatch(){
        return matchService.getAllMatch();
    }
    @GetMapping("/matches/{matchId}")
    public MatchFootDTO getMatch(@PathVariable Long matchId){
        return matchService.getMatch(matchId);
    }
}
