package example.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.services.SpecialtyService;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
