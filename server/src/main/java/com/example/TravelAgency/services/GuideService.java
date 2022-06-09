package com.example.TravelAgency.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.GuideDTO;
import com.example.TravelAgency.models.Guide;
import com.example.TravelAgency.repository.GuideRepository;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    @Autowired
    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<GuideDTO> getGuides() {
        List<Guide> guides = guideRepository.findAll();
        List<GuideDTO> guideDTOs = new ArrayList<GuideDTO>();

        for (Guide g : guides) {
            GuideDTO gDTO = new GuideDTO();
            gDTO.setGuideId(g.getGuideId());
            gDTO.setName(g.getName());
            gDTO.setLastName(g.getLastName());
            gDTO.setAddress(g.getAddress());
            gDTO.setPhone(g.getPhone());
            gDTO.setEmail(g.getEmail());
            gDTO.setDateOfBirth(g.getDateOfBirth());
            guideDTOs.add(gDTO);
        }

        return guideDTOs;
    }

    public GuideDTO findGuideById(Integer guideId) {
        Guide g = guideRepository.findById(guideId).orElseThrow(() -> new IllegalStateException(
                "Guide with id " + guideId + "does not exist"));
        GuideDTO gDTO = new GuideDTO();

        gDTO.setGuideId(g.getGuideId());
        gDTO.setName(g.getName());
        gDTO.setLastName(g.getLastName());
        gDTO.setAddress(g.getAddress());
        gDTO.setPhone(g.getPhone());
        gDTO.setEmail(g.getEmail());
        gDTO.setDateOfBirth(g.getDateOfBirth());

        return gDTO;
    }

    public GuideDTO updateGuide(Integer guideId, Guide newGuide) {
        Guide g = guideRepository.findById(guideId).orElseThrow(() -> new IllegalStateException(
                "Guide with id " + guideId + " does not exist"));

        g.setName(newGuide.getName());
        g.setLastName(newGuide.getLastName());
        g.setAddress(newGuide.getAddress());
        g.setPhone(newGuide.getPhone());
        g.setEmail(newGuide.getEmail());
        g.setDateOfBirth(newGuide.getDateOfBirth());

        Guide saveGuide = guideRepository.save(g);

        GuideDTO gDTO = new GuideDTO();

        gDTO.setGuideId(saveGuide.getGuideId());
        gDTO.setName(saveGuide.getName());
        gDTO.setLastName(saveGuide.getLastName());
        gDTO.setAddress(saveGuide.getAddress());
        gDTO.setPhone(saveGuide.getPhone());
        gDTO.setEmail(saveGuide.getEmail());
        gDTO.setDateOfBirth(saveGuide.getDateOfBirth());

        return gDTO;
    }

    public GuideDTO addGuide(GuideDTO guide) {
        Optional<Guide> guideExists = guideRepository.findByNameOrLastName(guide.getName(),
                guide.getLastName());

        if (guideExists.isPresent()) {
            throw new IllegalStateException("Guide already exists");
        }

        Guide g = new Guide();

        g.setName(guide.getName());
        g.setLastName(guide.getLastName());
        g.setAddress(guide.getAddress());
        g.setPhone(guide.getPhone());
        g.setEmail(guide.getEmail());
        g.setDateOfBirth(guide.getDateOfBirth());

        Guide saveGuide = guideRepository.save(g);

        GuideDTO gDTO = new GuideDTO();

        gDTO.setGuideId(saveGuide.getGuideId());
        gDTO.setName(saveGuide.getName());
        gDTO.setLastName(saveGuide.getLastName());
        gDTO.setAddress(saveGuide.getAddress());
        gDTO.setPhone(saveGuide.getPhone());
        gDTO.setEmail(saveGuide.getEmail());
        gDTO.setDateOfBirth(saveGuide.getDateOfBirth());

        return gDTO;
    }

    public void deleteGuide(Integer guideId) {
        boolean exist = guideRepository.existsById(guideId);
        if (!exist) {
            throw new IllegalStateException("Guide with id " + guideId + " does not exist");
        }

        guideRepository.deleteById(guideId);
    }
}
