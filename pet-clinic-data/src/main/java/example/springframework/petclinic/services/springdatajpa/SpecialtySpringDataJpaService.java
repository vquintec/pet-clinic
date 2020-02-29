package example.springframework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.repositories.SpecialtyRepository;
import example.springframework.petclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySpringDataJpaService extends AbstractSpringDataJpaService<Specialty, Long, SpecialtyRepository> implements SpecialtyService {

    public SpecialtySpringDataJpaService(SpecialtyRepository specialtyRepository) {
        super(specialtyRepository);
    }

}
