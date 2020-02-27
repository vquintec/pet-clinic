package example.springframework.petclinic.model;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity {
    private LocalDate birthDate;
    private PetType type;
    private Owner owner;
    private Set<Visit> visit;
}
