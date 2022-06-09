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

import com.example.TravelAgency.controllers.dto.AddDestinationDTO;
import com.example.TravelAgency.controllers.dto.DestinationCompleteDataDTO;
import com.example.TravelAgency.services.DestinationService;

@RestController
@CrossOrigin
public class DestinationController {

    @Autowired
    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping(path = "api/v1/destinations")
    public List<DestinationCompleteDataDTO> getDestinations() {
        return destinationService.getDestinations();
    }

    @GetMapping(path = "api/v1/destinations/{dId}")
    public DestinationCompleteDataDTO findDestinationById(@PathVariable("dId") Integer dId) {
        return destinationService.findDestinationById(dId);
    }

    @PutMapping(path = "api/v1/destinations/update/{dId}")
    public DestinationCompleteDataDTO updateDestination(@PathVariable("dId") Integer dId,
            @RequestBody AddDestinationDTO destination) {
        return destinationService.updateDestination(dId, destination);
    }

    @PostMapping(path = "api/v1/destinations/add")
    public DestinationCompleteDataDTO addDestination(@RequestBody AddDestinationDTO destination) {
        return destinationService.addDestination(destination);
    }

    @DeleteMapping(path = "api/v1/destinations/delete/{dId}")
    public void deleteDestination(@PathVariable("dId") Integer dId) {
        destinationService.deleteDestination(dId);
    }

}
