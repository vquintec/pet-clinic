package example.springframework.petclinic.map;

import example.springframework.petclinic.model.Vet;
import example.springframework.petclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }
    
}
