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

import com.example.TravelAgency.controllers.dto.DifficultyLevelDTO;
import com.example.TravelAgency.models.DifficultyLevel;
import com.example.TravelAgency.services.DifficultyLevelService;

@RestController
@CrossOrigin
public class DifficultyLevelController {

    @Autowired
    private final DifficultyLevelService difficultyLevelService;

    public DifficultyLevelController(DifficultyLevelService difficultyLevelService) {
        this.difficultyLevelService = difficultyLevelService;
    }

    @GetMapping(path = "api/v1/difficultyLevels")
    public List<DifficultyLevelDTO> getCities() {
        return difficultyLevelService.getDifficultyLevel();
    }

    @GetMapping(path = "api/v1/difficultyLevels/{dlID}")
    public DifficultyLevelDTO findDifficultyLevelById(@PathVariable("dlID") Integer dlID) {
        return difficultyLevelService.findDifficultyLevelById(dlID);
    }

    @PutMapping(path = "api/v1/difficultyLevels/update/{dlID}")
    public DifficultyLevelDTO updateDifficultyLevel(@PathVariable("dlID") Integer dlID,
            @RequestBody DifficultyLevel difficultyLevel) {
        return difficultyLevelService.updateDifficultyLevel(dlID, difficultyLevel);
    }

    @PostMapping(path = "api/v1/difficultyLevels/add")
    public DifficultyLevelDTO addDifficultyLevel(@RequestBody DifficultyLevelDTO difficultyLevel) {
        return difficultyLevelService.addDifficultyLevel(difficultyLevel);
    }

    @DeleteMapping(path = "api/v1/difficultyLevels/delete/{dlID}")
    public void deleteDifficultyLevel(@PathVariable("dlID") Integer dlID) {
        difficultyLevelService.deleteDifficultyLevel(dlID);
    }

}
