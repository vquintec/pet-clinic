package example.springframework.petclinic.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    

}
