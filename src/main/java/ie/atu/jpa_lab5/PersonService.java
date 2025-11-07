package ie.atu.jpa_lab5;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) {this.repo = repo;} // Denpendency injection

    public Person create(Person p) {return repo.save(p);}
}
