package example.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;

import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.model.Vet;
import example.springframework.petclinic.services.SpecialtyService;
import example.springframework.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    
    private final SpecialtyService specialtyService;
    
    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if(vet != null) {
            if(vet.getSpecialties() != null) {
                vet.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(vet);
        }else {
            return null;
        }
        
    }
}
