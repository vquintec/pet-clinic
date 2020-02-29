package example.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import example.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
