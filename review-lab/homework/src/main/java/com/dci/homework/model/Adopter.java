package com.dci.homework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Adopter {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String fullName;

    private String phone;

    @ManyToMany(mappedBy = "adopters")
    private List<Pet> adoptedPets;
}
