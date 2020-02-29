package example.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
