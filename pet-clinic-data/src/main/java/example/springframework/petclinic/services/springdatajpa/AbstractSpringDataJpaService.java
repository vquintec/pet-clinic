package example.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractSpringDataJpaService<T, ID, E extends CrudRepository<T, ID>> {
    
    private final E objectRepository;
    
    public AbstractSpringDataJpaService(E objectRepository) {
        this.objectRepository = objectRepository;
    }

    public Set<T> findAll() {
        Set<T> objects = new HashSet<>();
        objectRepository.findAll().forEach(objects::add);
        return objects;
    }

    public T findById(ID id) {
        return objectRepository.findById(id).orElse(null);
    }

    public T save(T object) {
        return objectRepository.save(object);
    }

    public void delete(T object) {
        objectRepository.delete(object);
    }
    
    public void deleteById(ID id) {
        objectRepository.deleteById(id);
    }
}
