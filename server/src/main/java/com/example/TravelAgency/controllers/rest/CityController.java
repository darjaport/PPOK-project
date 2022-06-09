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

import com.example.TravelAgency.controllers.dto.CityDTO;
import com.example.TravelAgency.models.City;
import com.example.TravelAgency.services.CityService;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(path = "api/v1/cities")
    public List<CityDTO> getCities() {
        return cityService.getCities();
    }

    @GetMapping(path = "api/v1/cities/{cityId}")
    public CityDTO findCityById(@PathVariable("cityId") Integer cityId) {
        return cityService.findCityById(cityId);
    }

    @PutMapping(path = "api/v1/cities/update/{cityId}")
    public CityDTO updateCity(@PathVariable("cityId") Integer cityId, @RequestBody City city) {
        return cityService.updateCity(cityId, city);
    }

    @PostMapping(path = "api/v1/cities/add")
    public CityDTO addCity(@RequestBody CityDTO city) {
        return cityService.addCity(city);
    }

    @DeleteMapping(path = "api/v1/cities/delete/{cityId}")
    public void deleteCity(@PathVariable("cityId") Integer cityId) {
        cityService.deleteCity(cityId);
    }
}
