package com.example.stade.clients;

import com.example.stade.model.Stade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STADE-SERVICE")
public interface StadeRestClient {
    @GetMapping("/stades/{id}")
    Stade findStadeById(@PathVariable Long id);
    @GetMapping("/stades")
    List<Stade> allStades();
}
