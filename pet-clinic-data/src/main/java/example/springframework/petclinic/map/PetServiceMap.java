package example.springframework.petclinic.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
