package example.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.PetType;
import example.springframework.petclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
