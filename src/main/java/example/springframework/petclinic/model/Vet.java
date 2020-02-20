package example.springframework.petclinic.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person{
    private Set<Specialty> specialties;
}
