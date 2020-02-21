package example.springframework.petclinic.model;

import java.io.Serializable;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class BaseEntity implements Serializable {
    private Long id;
}
