package com.dci.homework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;
    private String name;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "adoption_center_id")
    private AdoptionCenter center;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "adopters_pets",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "adopter_id"))
    private List<Adopter> adopters;
}
