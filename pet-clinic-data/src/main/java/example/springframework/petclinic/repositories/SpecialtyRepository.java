package example.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import example.springframework.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
