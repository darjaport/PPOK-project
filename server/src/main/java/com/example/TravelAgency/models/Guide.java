package com.example.TravelAgency.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guideId;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;

    // @OneToMany(orphanRemoval = true, mappedBy = "guide")
    @OneToMany(mappedBy = "guide")
    private List<Destination> destinations;

    public Guide() {
    }

    public Guide(String name, String lastName, String address, String phone, String email, LocalDate dateOfBirth,
            List<Destination> destinations) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.destinations = destinations;
    }

    public Guide(int guideId, String name, String lastName, String address, String phone, String email,
            LocalDate dateOfBirth, List<Destination> destinations) {
        this.guideId = guideId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
