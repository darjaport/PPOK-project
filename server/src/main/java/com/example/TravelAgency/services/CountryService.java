package com.example.TravelAgency.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.CountryDTO;
import com.example.TravelAgency.models.Country;
import com.example.TravelAgency.repository.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getCountries() {
        List<Country> cities = countryRepository.findAll();
        List<CountryDTO> citiesDTO = new ArrayList<CountryDTO>();

        for (Country c : cities) {
            CountryDTO cDTO = new CountryDTO();
            cDTO.setCountryId(c.getCountryId());
            cDTO.setName(c.getName());
            citiesDTO.add(cDTO);
        }

        return citiesDTO;
    }

    public CountryDTO findCountryById(Integer countryId) {
        Country c = countryRepository.findById(
                countryId).orElseThrow(
                        () -> new IllegalStateException(
                                "Country with id " + countryId + " does not exist"));
        CountryDTO cDTO = new CountryDTO();

        cDTO.setCountryId(c.getCountryId());
        cDTO.setName(c.getName());

        return cDTO;
    }

    public CountryDTO updateCountry(Integer countryId, Country newCountry) {
        Country c = countryRepository.findById(
                countryId).orElseThrow(
                        () -> new IllegalStateException(
                                "Country with id " + countryId + " does not exist"));

        c.setName(newCountry.getName());

        Country saveCountry = countryRepository.save(c);

        CountryDTO cDTO = new CountryDTO();

        cDTO.setCountryId(saveCountry.getCountryId());
        cDTO.setName(saveCountry.getName());

        return cDTO;
    }

    public CountryDTO addCountry(CountryDTO country) {
        Optional<Country> countryExists = countryRepository.findByName(country.getName());

        if (countryExists.isPresent()) {
            throw new IllegalStateException("Country already exists");
        }

        Country c = new Country();
        c.setName(country.getName());

        Country saveCountry = countryRepository.save(c);

        CountryDTO cDTO = new CountryDTO();
        cDTO.setCountryId(saveCountry.getCountryId());
        cDTO.setName(saveCountry.getName());

        return cDTO;
    }

    public void deleteCountry(Integer countryId) {
        boolean exist = countryRepository.existsById(countryId);
        if (!exist) {
            throw new IllegalStateException("Country with id " + countryId + " does not exist");
        }

        countryRepository.deleteById(countryId);
    }
}
