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

import com.example.TravelAgency.controllers.dto.CountryDTO;
import com.example.TravelAgency.models.Country;
import com.example.TravelAgency.services.CountryService;

@RestController
@CrossOrigin
public class CountryController {

    @Autowired
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "api/v1/countries")
    public List<CountryDTO> getCities() {
        return countryService.getCountries();
    }

    @GetMapping(path = "api/v1/countries/{countryId}")
    public CountryDTO findCountryById(@PathVariable("countryId") Integer countryId) {
        return countryService.findCountryById(countryId);
    }

    @PutMapping(path = "api/v1/countries/update/{countryId}")
    public CountryDTO updateCountry(@PathVariable("countryId") Integer countryId, @RequestBody Country country) {
        return countryService.updateCountry(countryId, country);
    }

    @PostMapping(path = "api/v1/countries/add")
    public CountryDTO addCountry(@RequestBody CountryDTO country) {
        return countryService.addCountry(country);
    }

    @DeleteMapping(path = "api/v1/countries/delete/{countryId}")
    public void deleteCountry(@PathVariable("countryId") Integer countryId) {
        countryService.deleteCountry(countryId);
    }

}
