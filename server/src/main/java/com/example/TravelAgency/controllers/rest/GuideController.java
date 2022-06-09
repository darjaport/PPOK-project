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

import com.example.TravelAgency.controllers.dto.GuideDTO;
import com.example.TravelAgency.models.Guide;
import com.example.TravelAgency.services.GuideService;

@RestController
@CrossOrigin
public class GuideController {

    @Autowired
    private final GuideService guideService;

    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping(path = "api/v1/guides")
    public List<GuideDTO> getGuides() {
        return guideService.getGuides();
    }

    @GetMapping(path = "api/v1/guides/{guideId}")
    public GuideDTO findGuideById(@PathVariable("guideId") Integer guideId) {
        return guideService.findGuideById(guideId);
    }

    @PutMapping(path = "api/v1/guides/update/{guideId}")
    public GuideDTO updateGuide(@PathVariable("guideId") Integer guideId, @RequestBody Guide guide) {
        return guideService.updateGuide(guideId, guide);
    }

    @PostMapping(path = "api/v1/guides/add")
    public GuideDTO addGuide(@RequestBody GuideDTO guide) {
        return guideService.addGuide(guide);
    }

    @DeleteMapping(path = "api/v1/guides/delete/{guideId}")
    public void deleteGuide(@PathVariable("guideId") Integer guideId) {
        guideService.deleteGuide(guideId);
    }
}
