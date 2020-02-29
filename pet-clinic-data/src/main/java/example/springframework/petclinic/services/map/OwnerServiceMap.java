package example.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.services.OwnerService;
import example.springframework.petclinic.services.PetService;
import example.springframework.petclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;
    
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }
    
    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            if(owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if(pet.getType() != null && pet.getType().getId() == null) {
                        pet.setType(petTypeService.save(pet.getType()));
                    } else if(pet.getType() == null) {
                        throw new RuntimeException("Pet type is required");
                    }
                    
                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        }else {
            return null;
        }
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

}
