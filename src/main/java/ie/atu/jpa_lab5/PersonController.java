package ie.atu.jpa_lab5;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) { this.service = service ; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person){
        return service.create(person);
    }

    @GetMapping("/{id}")
    public Person byEmployeeId(@PathVariable String id){
        return service.findByEmployeeId(id);
    }
}
