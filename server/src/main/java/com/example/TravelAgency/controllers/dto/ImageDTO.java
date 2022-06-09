package com.example.TravelAgency.controllers.dto;

public class ImageDTO {
    private int imageId;
    private String name;
    private String src;

    public ImageDTO() {
    }

    public ImageDTO(String name, String src) {
        this.name = name;
        this.src = src;
    }

    public ImageDTO(int imageId, String name, String src) {
        this.imageId = imageId;
        this.name = name;
        this.src = src;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
