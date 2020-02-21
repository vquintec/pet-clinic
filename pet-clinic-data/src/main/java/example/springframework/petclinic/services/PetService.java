package example.springframework.petclinic.services;

import java.util.Set;

import example.springframework.petclinic.model.Pet;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
