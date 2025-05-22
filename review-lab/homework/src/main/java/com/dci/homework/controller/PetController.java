package com.dci.homework.controller;

import com.dci.homework.model.Pet;
import com.dci.homework.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public String getPets(Model model) {
        model.addAttribute("pets", petService.getPets());
        return "pets-list";
    }

    @GetMapping("/{petId}")
    public String petInfo(@PathVariable("petId") Long petId, Model model) {
        model.addAttribute("pet", petService.getPetById(petId));
        return "pet-info";
    }

    @GetMapping("/new")
    public String newPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet-form";
    }

    @PostMapping("/create")
    public String savePet(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets/" + pet.getPetId();
    }

    @GetMapping("/edit/{petId}")
    public String editPet(@PathVariable("petId") Long petId, Model model) {
        model.addAttribute("pet", petService.getPetById(petId));
        return "pet-form";
    }

    @PostMapping("/edit/{petId}")
    public String updatePet(@PathVariable("petId") Long petId, @ModelAttribute("pet") Pet pet) {
        pet.setPetId(petId);
        petService.savePet(pet);
        return "redirect:/pets/" + petId;
    }

    @PostMapping("/delete/{petId}")
    public String deletePet(@PathVariable("petId") Long petId) {
        petService.deletePet(petId);
        return "redirect:/pets";
    }

}
