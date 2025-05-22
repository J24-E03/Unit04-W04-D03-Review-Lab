package com.dci.homework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class AdoptionCenter {
    @Id
    @GeneratedValue
    private Long adoptionCenterId;

    @NotBlank(message = "Center name is required")
    private String name;

    private String location;

    @OneToMany(mappedBy = "center")
    private List<Pet> pets;
}
