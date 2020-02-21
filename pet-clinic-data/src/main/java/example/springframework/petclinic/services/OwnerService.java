package example.springframework.petclinic.services;

import java.util.Set;

import example.springframework.petclinic.model.Owner;

public interface OwnerService {
    
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    
}