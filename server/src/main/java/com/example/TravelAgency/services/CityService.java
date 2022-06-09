package com.example.TravelAgency.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.CityDTO;
import com.example.TravelAgency.models.City;
import com.example.TravelAgency.repository.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getCities() {
        List<City> cities = cityRepository.findAll();
        List<CityDTO> citiesDTO = new ArrayList<CityDTO>();

        for (City c : cities) {
            CityDTO cDTO = new CityDTO();
            cDTO.setCityId(c.getCityId());
            cDTO.setName(c.getName());
            citiesDTO.add(cDTO);
        }

        return citiesDTO;
    }

    public CityDTO findCityById(Integer cityId) {
        City c = cityRepository.findById(
                cityId).orElseThrow(
                        () -> new IllegalStateException(
                                "City with id " + cityId + " does not exist"));
        CityDTO cDTO = new CityDTO();

        cDTO.setCityId(c.getCityId());
        cDTO.setName(c.getName());

        return cDTO;
    }

    public CityDTO updateCity(Integer cityId, City newCity) {
        City c = cityRepository.findById(
                cityId).orElseThrow(
                        () -> new IllegalStateException(
                                "City with id " + cityId + " does not exist"));

        c.setName(newCity.getName());

        City saveCity = cityRepository.save(c);

        CityDTO cDTO = new CityDTO();

        cDTO.setCityId(saveCity.getCityId());
        cDTO.setName(saveCity.getName());

        return cDTO;
    }

    public CityDTO addCity(CityDTO city) {
        // City cityExists = cityRepository.findByName(city.getName()).get();
        Optional<City> cityExists = cityRepository.findByName(city.getName());

        if (cityExists.isPresent()) {
            throw new IllegalStateException("City already exists");
        }

        City c = new City();
        c.setName(city.getName());

        City saveCity = cityRepository.save(c);

        CityDTO cDTO = new CityDTO();
        cDTO.setCityId(saveCity.getCityId());
        cDTO.setName(saveCity.getName());

        return cDTO;
    }

    public void deleteCity(Integer cityId) {
        boolean exist = cityRepository.existsById(cityId);
        if (!exist) {
            throw new IllegalStateException("City with id " + cityId + " does not exist");
        }

        cityRepository.deleteById(cityId);
    }

}
