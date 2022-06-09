package com.example.TravelAgency.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.ContinentDTO;
import com.example.TravelAgency.models.Continent;
import com.example.TravelAgency.repository.ContinentRepository;

@Service
public class ContinentService {

    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<ContinentDTO> getContinents() {
        List<Continent> continents = continentRepository.findAll();
        List<ContinentDTO> continentsDTO = new ArrayList<ContinentDTO>();

        for (Continent c : continents) {
            ContinentDTO cDTO = new ContinentDTO();
            cDTO.setContinentId(c.getContinentId());
            cDTO.setName(c.getName());
            continentsDTO.add(cDTO);
        }

        return continentsDTO;
    }

    public ContinentDTO findContinentById(Integer continentId) {
        Continent c = continentRepository.findById(
                continentId).orElseThrow(
                        () -> new IllegalStateException(
                                "Continent with id " + continentId + " does not exist"));
        ContinentDTO cDTO = new ContinentDTO();

        cDTO.setContinentId(c.getContinentId());
        cDTO.setName(c.getName());

        return cDTO;
    }

    public ContinentDTO updateContinent(Integer continentId, Continent newContinent) {
        Continent c = continentRepository.findById(
                continentId).orElseThrow(
                        () -> new IllegalStateException(
                                "Continent with id " + continentId + " does not exist"));

        c.setName(newContinent.getName());

        Continent saveContinent = continentRepository.save(c);

        ContinentDTO cDTO = new ContinentDTO();

        cDTO.setContinentId(saveContinent.getContinentId());
        cDTO.setName(saveContinent.getName());

        return cDTO;
    }

    public ContinentDTO addContinent(ContinentDTO continent) {
        Optional<Continent> continentExists = continentRepository.findByName(continent.getName());

        if (continentExists.isPresent()) {
            throw new IllegalStateException("Continent already exists");
        }

        Continent c = new Continent();
        c.setName(continent.getName());

        Continent saveContinent = continentRepository.save(c);

        ContinentDTO cDTO = new ContinentDTO();
        cDTO.setContinentId(saveContinent.getContinentId());
        cDTO.setName(saveContinent.getName());

        return cDTO;
    }

    public void deleteContinent(Integer continentId) {
        boolean exist = continentRepository.existsById(continentId);
        if (!exist) {
            throw new IllegalStateException("Continent with id " + continentId + " does not exist");
        }

        continentRepository.deleteById(continentId);
    }

}
