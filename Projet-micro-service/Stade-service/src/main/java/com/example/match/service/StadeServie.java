package com.example.match.service;

import com.example.match.dtos.StadeDTO;

public interface StadeServie {
    StadeDTO saveStade (StadeDTO stadeDTO);
    StadeDTO getStade(Long StadeId);
}
