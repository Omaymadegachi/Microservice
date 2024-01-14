package com.example.stade;

import com.example.stade.entities.Arbitre;
import com.example.stade.entities.Entraineur;
import com.example.stade.entities.Joueur;
import com.example.stade.entities.Personne;
import com.example.stade.enums.JoueurRole;
import com.example.stade.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;
@EnableFeignClients
@SpringBootApplication
public class StadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StadeApplication.class, args);
    }

}
