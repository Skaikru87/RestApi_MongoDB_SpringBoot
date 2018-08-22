package pl.mkm.MongoDBExamples.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mkm.MongoDBExamples.data.Person;
import pl.mkm.MongoDBExamples.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody Person person) {
        person.set_id(ObjectId.get());
        personRepository.save(person);
        return person;
    }
    @GetMapping("/getPeople")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }
    @PutMapping("/update/{id}")
    public void updatePersonById(@PathVariable("id") ObjectId id, @RequestBody Person person) {
        person.set_id(id);
        personRepository.save(person);
    }
    @GetMapping("/getById/{id}")
    public Person getById(@PathVariable("id") ObjectId id){
        return personRepository.findBy_id(id);
    }
    @GetMapping("/getByFirstName/{firstName}")
    public List<Person> getByFirstName(@PathVariable("firstName") String firstName){
        return personRepository.findByFirstName(firstName);
    }
    @GetMapping("/getByLastName/{lastName}")
    public List<Person> getByLastName(@PathVariable("lastName") String lastName){
        return personRepository.findByLastName(lastName);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable("id") ObjectId id){
        personRepository.delete(personRepository.findBy_id(id));
    }
}
