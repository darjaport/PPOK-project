package com.example.TravelAgency.controllers.dto;

public class DifficultyLevelDTO {
    private int difficultyLevelId;
    private String name;

    public DifficultyLevelDTO() {
    }

    public DifficultyLevelDTO(String name) {
        this.name = name;
    }

    public DifficultyLevelDTO(int difficultyLevelId, String name) {
        this.difficultyLevelId = difficultyLevelId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficultyLevelId() {
        return difficultyLevelId;
    }

    public void setDifficultyLevelId(int difficultyLevelId) {
        this.difficultyLevelId = difficultyLevelId;
    }
}
