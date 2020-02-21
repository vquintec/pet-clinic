package example.springframework.petclinic.map;

import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long>{

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
