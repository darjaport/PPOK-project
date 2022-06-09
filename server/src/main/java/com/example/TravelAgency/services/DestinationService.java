package com.example.TravelAgency.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.AddDestinationDTO;
import com.example.TravelAgency.controllers.dto.DestinationCompleteDataDTO;
import com.example.TravelAgency.controllers.dto.ImageDTO;
import com.example.TravelAgency.models.City;
import com.example.TravelAgency.models.Continent;
import com.example.TravelAgency.models.Country;
import com.example.TravelAgency.models.Destination;
import com.example.TravelAgency.models.DifficultyLevel;
import com.example.TravelAgency.models.Guide;
import com.example.TravelAgency.models.Image;
import com.example.TravelAgency.repository.CityRepository;
import com.example.TravelAgency.repository.ContinentRepository;
import com.example.TravelAgency.repository.CountryRepository;
import com.example.TravelAgency.repository.DestinationRepository;
import com.example.TravelAgency.repository.DifficultyLevelRepository;
import com.example.TravelAgency.repository.GuideRepository;
import com.example.TravelAgency.repository.ImageRepository;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Autowired
    GuideRepository guideRepository;

    @Autowired
    DifficultyLevelRepository difficultyLevelRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    @Autowired
    ImageRepository imageRepository;

    public List<DestinationCompleteDataDTO> getDestinations() {

        List<Destination> destinations = destinationRepository.findAll();
        List<DestinationCompleteDataDTO> destinationsDTO = new ArrayList<DestinationCompleteDataDTO>();

        for (Destination d : destinations) {
            destinationsDTO.add(setDTO(d));
        }

        return destinationsDTO;
    }

    public DestinationCompleteDataDTO findDestinationById(Integer dId) {
        Destination d = destinationRepository.findById(
                dId).orElseThrow(() -> new IllegalStateException("Destination with id " + dId + " does not exist"));

        return setDTO(d);
    }

    public DestinationCompleteDataDTO updateDestination(Integer dId, AddDestinationDTO newDestination) {
        // TODO: update images

        Destination d = destinationRepository.findById(dId).get();

        Guide g = guideRepository.findById(newDestination.getGuideId()).get();
        DifficultyLevel dl = difficultyLevelRepository.findById(newDestination.getDifficultyLevelId()).get();

        Continent continent = continentRepository.findById(newDestination.getContinentId()).get();
        Optional<Country> country = countryRepository.findByName(newDestination.getCountryName());
        Optional<City> city = cityRepository.findByName(newDestination.getCityName());

        Country getCountry = new Country();
        if (!country.isPresent()) {
            Country newCountry = new Country(newDestination.getCountryName(), continent);
            getCountry = countryRepository.save(newCountry);
        } else {
            getCountry = country.get();
        }

        City getCity = new City();
        if (!city.isPresent()) {
            City newCity = new City(newDestination.getCityName(), getCountry);
            getCity = cityRepository.save(newCity);
        } else {
            getCity = city.get();
        }

        // List<Image> images = new ArrayList<Image>();

        d.setName(newDestination.getName());
        d.setDescription(newDestination.getDescription());
        d.setPrice(newDestination.getPrice());
        d.setGroupSize(newDestination.getGroupSize());
        d.setStartDate(newDestination.getStartDate());
        d.setEndDate(newDestination.getEndDate());
        d.setDateAdded(LocalDate.now());
        d.setGuide(g);
        d.setDifficultyLevel(dl);
        d.setCity(getCity);
        // d.setImages(images);

        Destination saveDestination = destinationRepository.save(d);

        return setDTO(saveDestination);
    }

    public DestinationCompleteDataDTO addDestination(AddDestinationDTO newDestination) {
        // TODO: add images

        Destination d = new Destination();

        Guide g = guideRepository.findById(newDestination.getGuideId()).get();
        DifficultyLevel dl = difficultyLevelRepository.findById(newDestination.getDifficultyLevelId()).get();

        Continent continent = continentRepository.findById(newDestination.getContinentId()).get();
        Optional<Country> country = countryRepository.findByName(newDestination.getCountryName());
        Optional<City> city = cityRepository.findByName(newDestination.getCityName());

        Country getCountry = new Country();
        if (!country.isPresent()) {
            Country newCountry = new Country(newDestination.getCountryName(), continent);
            getCountry = countryRepository.save(newCountry);
        } else {
            getCountry = country.get();
        }

        City getCity = new City();
        if (!city.isPresent()) {
            City newCity = new City(newDestination.getCityName(), getCountry);
            getCity = cityRepository.save(newCity);
        } else {
            getCity = city.get();
        }

        List<Image> images = new ArrayList<Image>();

        d.setName(newDestination.getName());
        d.setDescription(newDestination.getDescription());
        d.setPrice(newDestination.getPrice());
        d.setGroupSize(newDestination.getGroupSize());
        d.setStartDate(newDestination.getStartDate());
        d.setEndDate(newDestination.getEndDate());
        d.setDateAdded(LocalDate.now());
        d.setGuide(g);
        d.setDifficultyLevel(dl);
        d.setCity(getCity);
        d.setImages(images);

        Destination saveDestination = destinationRepository.save(d);

        return setDTO(saveDestination);
    }

    public void deleteDestination(Integer dId) {
        Destination d = destinationRepository.findById(dId).orElseThrow(() -> new IllegalStateException(
                "Destination with id " + dId + " does not exist"));

        List<Image> images = imageRepository.findAllByDestination(d);

        for (Image i : images) {
            imageRepository.deleteById(i.getImageId());
        }

        destinationRepository.deleteById(dId);
    }

    public DestinationCompleteDataDTO setDTO(Destination d) {
        DestinationCompleteDataDTO dDTO = new DestinationCompleteDataDTO();

        dDTO.setDestinationId(d.getDestinationId());
        dDTO.setName(d.getName());
        dDTO.setDescription(d.getDescription());
        dDTO.setPrice(d.getPrice());
        dDTO.setGroupSize(d.getGroupSize());
        dDTO.setStartDate(d.getStartDate());
        dDTO.setEndDate(d.getEndDate());
        dDTO.setDateAdded(d.getDateAdded());
        dDTO.setTripLength(d.getTripLength());
        dDTO.setGuideId(d.getGuide().getGuideId());
        dDTO.setGuideName(d.getGuide().getName());
        dDTO.setGuideLastName(d.getGuide().getLastName());
        dDTO.setDifficultyLevelName(d.getDifficultyLevel().getName());
        dDTO.setDifficultyLevelId(d.getDifficultyLevel().getDifficultyLevelId());
        dDTO.setCityName(d.getCity().getName());
        dDTO.setCountryName(d.getCity().getCountry().getName());
        dDTO.setContinentName(d.getCity().getCountry().getContinent().getName());
        dDTO.setContinentId(d.getCity().getCountry().getContinent().getContinentId());

        List<ImageDTO> images = new ArrayList<ImageDTO>();
        for (Image i : d.getImages()) {
            ImageDTO newImg = new ImageDTO();

            newImg.setImageId(i.getImageId());
            newImg.setName(i.getName());
            newImg.setSrc(i.getSrc());

            images.add(newImg);
        }
        dDTO.setImageList(images);

        return dDTO;
    }

}
