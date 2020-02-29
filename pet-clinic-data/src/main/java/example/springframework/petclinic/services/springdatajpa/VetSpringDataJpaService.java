package example.springframework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Vet;
import example.springframework.petclinic.repositories.VetRepository;
import example.springframework.petclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSpringDataJpaService extends AbstractSpringDataJpaService<Vet, Long, VetRepository> implements VetService {

    public VetSpringDataJpaService(VetRepository vetRepository) {
        super(vetRepository);
    }

}
