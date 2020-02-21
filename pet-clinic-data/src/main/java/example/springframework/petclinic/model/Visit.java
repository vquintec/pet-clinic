package example.springframework.petclinic.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Visit extends BaseEntity {
    private Date date;
    private String description;
    private Pet pet;
}
