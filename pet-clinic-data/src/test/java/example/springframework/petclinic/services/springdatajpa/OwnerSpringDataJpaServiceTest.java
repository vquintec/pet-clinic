package example.springframework.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import example.springframework.petclinic.model.Owner;
import example.springframework.petclinic.repositories.OwnerRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    private static final String SMITH = "Smith";

    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSpringDataJpaService ownerService;
    
    Owner returnOwner;
    
    @BeforeEach
    void setUp() throws Exception {
        returnOwner = Owner.builder()
                .id(1L)
                .lastName(SMITH)
                .build();
    }

    @Test
    void testFindAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());
        
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        
        Set<Owner> owners = ownerService.findAll();
        
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void testFindById() {
        
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        
        Owner owner = ownerService.findById(1L);
        
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }
    
    @Test
    void testFindByIdNotFound() {
        
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        
        Owner owner = ownerService.findById(2L);
        
        assertNull(owner);
    }

    @Test
    void testSave() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        
        when(ownerRepository.save(any(Owner.class))).thenReturn(ownerToSave);
        
        Owner savedOwner = ownerService.save(ownerToSave);
        
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any(Owner.class));
    }

    @Test
    void testDelete() {
        ownerService.delete(returnOwner);
        
        verify(ownerRepository).delete(any(Owner.class));
    }

    @Test
    void testDeleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void testFindByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(returnOwner));
        
        Owner smith = ownerService.findByLastName(SMITH);
        
        assertEquals(SMITH, smith.getLastName());
        verify(ownerRepository).findByLastName(anyString());
    }

}
