package example.springframework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.repositories.PetRepository;
import example.springframework.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSpringDataJpaService extends AbstractSpringDataJpaService<Pet, Long, PetRepository> implements PetService {

    public PetSpringDataJpaService(PetRepository objectRepository) {
        super(objectRepository);
    }

}
