package example.springframework.petclinic.services.springdatajpa;

import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.repositories.SpecialtyRepository;
import example.springframework.petclinic.services.SpecialtyService;

public class SpecialtySpringDataJpaService extends AbstractSpringDataJpaService<Specialty, Long, SpecialtyRepository> implements SpecialtyService {

    public SpecialtySpringDataJpaService(SpecialtyRepository specialtyRepository) {
        super(specialtyRepository);
    }

}
