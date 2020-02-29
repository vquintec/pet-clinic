package example.springframework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Visit;
import example.springframework.petclinic.repositories.VisitRepository;
import example.springframework.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJpaService extends AbstractSpringDataJpaService<Visit, Long, VisitRepository> implements VisitService {

    public VisitSpringDataJpaService(VisitRepository objectRepository) {
        super(objectRepository);
    }

}
