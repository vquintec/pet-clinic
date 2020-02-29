package example.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.services.SpecialtyService;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
