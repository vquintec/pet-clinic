package example.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.model.Vet;
import example.springframework.petclinic.services.OwnerService;
import example.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Valentin");
        owner1.setLastName("Quintero");
        
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Mariana");
        owner2.setLastName("Quintero");
        
        ownerService.save(owner2);
        
        System.out.println("Loaded owners...");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Carlos");
        vet1.setLastName("Velez");
        
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Manuela");
        vet2.setLastName("Castrillon");
        
        vetService.save(vet2);
        
        System.out.println("Loaded vets...");
        
        
    }

}
