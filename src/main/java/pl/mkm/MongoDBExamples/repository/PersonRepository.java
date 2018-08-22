package pl.mkm.MongoDBExamples.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.mkm.MongoDBExamples.data.Person;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String>{

    Person findBy_id(ObjectId id);
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

}
