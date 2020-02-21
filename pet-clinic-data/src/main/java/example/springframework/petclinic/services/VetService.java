package example.springframework.petclinic.services;

import java.util.Set;

import example.springframework.petclinic.model.Vet;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
