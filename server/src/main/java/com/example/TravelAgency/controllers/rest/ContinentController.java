package com.example.TravelAgency.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TravelAgency.controllers.dto.ContinentDTO;
import com.example.TravelAgency.models.Continent;
import com.example.TravelAgency.services.ContinentService;

@RestController
@CrossOrigin
public class ContinentController {

    @Autowired
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping(path = "api/v1/continents")
    public List<ContinentDTO> getContinents() {
        return continentService.getContinents();
    }

    @GetMapping(path = "api/v1/continents/{continentId}")
    public ContinentDTO findContinentById(@PathVariable("continentId") Integer continentId) {
        return continentService.findContinentById(continentId);
    }

    @PutMapping(path = "api/v1/continents/update/{continentId}")
    public ContinentDTO updateContinent(@PathVariable("continentId") Integer continentId,
            @RequestBody Continent continent) {
        return continentService.updateContinent(continentId, continent);
    }

    @PostMapping(path = "api/v1/continents/add")
    public ContinentDTO addContinent(@RequestBody ContinentDTO continent) {
        return continentService.addContinent(continent);
    }

    @DeleteMapping(path = "api/v1/continents/delete/{continentId}")
    public void deleteContinent(@PathVariable("continentId") Integer continentId) {
        continentService.deleteContinent(continentId);
    }

}
