package example.springframework.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.model.Pet;
import example.springframework.petclinic.model.PetType;
import example.springframework.petclinic.model.Specialty;
import example.springframework.petclinic.model.Vet;
import example.springframework.petclinic.model.Visit;
import example.springframework.petclinic.services.OwnerService;
import example.springframework.petclinic.services.PetTypeService;
import example.springframework.petclinic.services.SpecialtyService;
import example.springframework.petclinic.services.VetService;
import example.springframework.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
            PetTypeService petTypeService, SpecialtyService specialtyService,
            VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        int countPetTypes = petTypeService.findAll().size();
        
        if(countPetTypes == 0) {
            loadData();
        }
        
    }

    private void loadData() {
        PetType dog = PetType.builder()
                .name("Dog")
                .build();
        PetType savedDogPetType = petTypeService.save(dog);
        
        PetType cat = PetType.builder()
                .name("Cat")
                .build();
        PetType savedCatPetType = petTypeService.save(cat);
        
        System.out.println("Loaded pet types...");
        
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);
        
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);
        
        System.out.println("Loaded specialties");
        
        Owner owner1 = new Owner();
        owner1.setFirstName("Valentin");
        owner1.setLastName("Quintero");
        owner1.setAddress("Cra 29 # 43-38");
        owner1.setCity("Medellín");
        owner1.setTelephone("3022147255");
        
        Pet beto = new Pet();
        beto.setType(savedDogPetType);
        beto.setOwner(owner1);
        beto.setName("Beto");
        beto.setBirthDate(LocalDate.now());
        
        owner1.getPets().add(beto);
        
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Mariana");
        owner2.setLastName("Quintero");
        owner2.setAddress("Cra 29 # 43-38");
        owner2.setCity("Medellín");
        owner2.setTelephone("3194587412");
        
        Pet kira = new Pet();
        kira.setType(savedCatPetType);
        kira.setOwner(owner2);
        kira.setName("Kira");
        kira.setBirthDate(LocalDate.now());
        
        owner2.getPets().add(kira);
        
        ownerService.save(owner2);
        
        System.out.println("Loaded owners...");
        
        Visit kiraVisit = new Visit();
        kiraVisit.setPet(kira);
        kiraVisit.setDate(LocalDate.now());
        kiraVisit.setDescription("Sneezy kitty");
        visitService.save(kiraVisit);
        
        System.out.println("Loaded visits...");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Carlos");
        vet1.setLastName("Velez");
        vet1.getSpecialties().add(savedRadiology);
        
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Manuela");
        vet2.setLastName("Castrillon");
        vet2.getSpecialties().add(savedSurgery);
        
        vetService.save(vet2);
        
        System.out.println("Loaded vets...");
    }

}
