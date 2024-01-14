package com.example.stade.repository;

import com.example.stade.entities.MatchFoot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchFoot,Long> {
}
