package example.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import example.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
