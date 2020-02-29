package example.springframework.petclinic.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import example.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
