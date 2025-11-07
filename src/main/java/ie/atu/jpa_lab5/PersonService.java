package ie.atu.jpa_lab5;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) {this.repo = repo;} // Denpendency injection

    public Person create(Person p) {return repo.save(p);}

    public Person findByEmployeeId(String id){
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not Found"));
    }

    public Person (String id ) {
        return repo.delete(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

}
