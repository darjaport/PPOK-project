package com.example.TravelAgency.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TravelAgency.controllers.dto.DifficultyLevelDTO;
import com.example.TravelAgency.models.DifficultyLevel;
import com.example.TravelAgency.repository.DifficultyLevelRepository;

@Service
public class DifficultyLevelService {

    private final DifficultyLevelRepository difficultyLevelRepository;

    @Autowired
    public DifficultyLevelService(DifficultyLevelRepository difficultyLevelRepository) {
        this.difficultyLevelRepository = difficultyLevelRepository;
    }

    public List<DifficultyLevelDTO> getDifficultyLevel() {
        List<DifficultyLevel> levels = difficultyLevelRepository.findAll();
        List<DifficultyLevelDTO> levelsDTO = new ArrayList<DifficultyLevelDTO>();

        for (DifficultyLevel l : levels) {
            DifficultyLevelDTO lDTO = new DifficultyLevelDTO();

            lDTO.setDifficultyLevelId(l.getDifficultyLevelId());
            lDTO.setName(l.getName());

            levelsDTO.add(lDTO);
        }

        return levelsDTO;
    }

    public DifficultyLevelDTO findDifficultyLevelById(Integer dlID) {
        DifficultyLevel l = difficultyLevelRepository.findById(dlID).orElseThrow(
                () -> new IllegalStateException(
                        "Difficulty level with id " + dlID + " does not exist"));

        DifficultyLevelDTO lDTO = new DifficultyLevelDTO();

        lDTO.setDifficultyLevelId(l.getDifficultyLevelId());
        lDTO.setName(l.getName());

        return lDTO;
    }

    public DifficultyLevelDTO updateDifficultyLevel(Integer dlID, DifficultyLevel newDifficultyLevel) {
        DifficultyLevel l = difficultyLevelRepository.findById(dlID).orElseThrow(
                () -> new IllegalStateException(
                        "DifficultyLevel with id " + dlID + " does not exist"));

        l.setName(newDifficultyLevel.getName());

        DifficultyLevel saveDifficultyLevel = difficultyLevelRepository.save(l);

        DifficultyLevelDTO lDTO = new DifficultyLevelDTO();

        lDTO.setDifficultyLevelId(saveDifficultyLevel.getDifficultyLevelId());
        lDTO.setName(saveDifficultyLevel.getName());

        return lDTO;
    }

    public DifficultyLevelDTO addDifficultyLevel(DifficultyLevelDTO difficultyLevel) {
        Optional<DifficultyLevel> difficultyLevelExists = difficultyLevelRepository
                .findById(difficultyLevel.getDifficultyLevelId());

        if (difficultyLevelExists.isPresent()) {
            throw new IllegalStateException("Difficulty level already exists");
        }

        DifficultyLevel l = new DifficultyLevel();
        l.setName(difficultyLevel.getName());

        DifficultyLevel saveDifficultyLevel = difficultyLevelRepository.save(l);

        DifficultyLevelDTO lDTO = new DifficultyLevelDTO();

        lDTO.setDifficultyLevelId(saveDifficultyLevel.getDifficultyLevelId());
        lDTO.setName(saveDifficultyLevel.getName());

        return lDTO;
    }

    public void deleteDifficultyLevel(Integer dlID) {
        boolean exist = difficultyLevelRepository.existsById(dlID);
        if (!exist) {
            throw new IllegalStateException("Difficulty level with id " + dlID + " does not exist");
        }

        difficultyLevelRepository.deleteById(dlID);
    }

}
