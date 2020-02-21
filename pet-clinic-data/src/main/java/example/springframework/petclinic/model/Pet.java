package example.springframework.petclinic.model;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity {
    private Date birthDate;
    private PetType type;
    private Owner owner;
    private Set<Visit> visit;
}
