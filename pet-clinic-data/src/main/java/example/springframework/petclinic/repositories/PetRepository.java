package example.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import example.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
