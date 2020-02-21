package example.springframework.petclinic.services;

import example.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    
    Owner findByLastName(String lastName);
}