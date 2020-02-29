package example.springframework.petclinic.services.map;

import example.springframework.petclinic.model.Visit;
import example.springframework.petclinic.services.VisitService;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    
    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }
}
