package example.springframework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.PetType;
import example.springframework.petclinic.repositories.PetTypeRepository;
import example.springframework.petclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSpringDataJpaService extends AbstractSpringDataJpaService<PetType, Long, PetTypeRepository> implements PetTypeService {

    public PetTypeSpringDataJpaService(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }

}
