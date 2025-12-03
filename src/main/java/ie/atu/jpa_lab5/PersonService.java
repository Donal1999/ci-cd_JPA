package ie.atu.jpa_lab5;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {
    private final PersonRepository repo; //data base layer
    public PersonService(PersonRepository repo) {this.repo = repo;} // Denpendency injection

    public Person create(Person p) {return repo.save(p);}

    public Person findByEmployeeId(String id){
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not Found"));
    }

    public Person deleteById(String id ) {
        Person person = repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
        repo.delete(person);
        return person;
    }

    public Person update(String id, Person updated) {
        Person person = repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
        person.setPosition(updated.getPosition());
        person.setDepartment(updated.getDepartment());
        return repo.save(person);
    }

}
