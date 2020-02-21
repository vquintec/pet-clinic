package example.springframework.petclinic.map;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    

}
