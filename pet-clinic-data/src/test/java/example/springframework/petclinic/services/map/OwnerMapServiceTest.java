package example.springframework.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.services.OwnerService;

class OwnerMapServiceTest {

    private static final String SMITH = "smith";
    private static final Long OWNER_ID = 1L;
    
    OwnerService ownerService;
    
    @BeforeEach
    void setUp() throws Exception {
        ownerService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerService.save(
                Owner.builder()
                .id(OWNER_ID)
                .lastName(SMITH)
                .build()
                );
    }
    
    @Test
    void testSaveOwnerWithExistingId() {
        Long id = 3L;
        
        Owner owner = Owner.builder()
                .id(id)
                .firstName("Carlos")
                .build();
        
        Owner savedOwner = ownerService.save(owner);
        
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void testSaveOwnerWithNonExistingId() {
        Long id = 2L;
        
        Owner owner = Owner.builder()
                .firstName("Carlos")
                .build();
        
        Owner savedOwner = ownerService.save(owner);
        
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void testFindAllWithZeroResults() {
        ownerService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Set<Owner> ownerSet = ownerService.findAll();
        assertEquals(0, ownerSet.size());
    }
    
    @Test
    void testFindAllWithOneResult() {
        Set<Owner> ownerSet = ownerService.findAll();
        assertEquals(1, ownerSet.size());
    }
    
    @Test
    void testFindAllWithMoreThanOneResult() {
        ownerService.save(Owner.builder()
                .firstName("Valentín")
                .build());
        Set<Owner> ownerSet = ownerService.findAll();
        assertEquals(2, ownerSet.size());
    }


    @Test
    void testFindById() {
        Owner owner = ownerService.findById(OWNER_ID);
        
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void testDelete() {
        ownerService.delete(ownerService.findById(OWNER_ID));
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void testDeleteById() {
        ownerService.deleteById(OWNER_ID);
        assertEquals(0, ownerService.findAll().size());
    }
    
    @Test
    void testFindByLastName() {
        Owner smith = ownerService.findByLastName(SMITH);
        
        assertNotNull(smith);
        assertEquals(OWNER_ID, smith.getId());
    }
    
    @Test
    void testFindByLastNameNotFound() {
        Owner quintero = ownerService.findByLastName("Quintero");
        
        assertNull(quintero);
    }

}
