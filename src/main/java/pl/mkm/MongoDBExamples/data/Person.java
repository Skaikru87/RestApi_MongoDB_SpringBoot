package pl.mkm.MongoDBExamples.data;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document()
public class Person {

    @Id
    private ObjectId _id;

    private String firstName;
    private String lastName;
    //***************************
    //important thing: id have to be convert to String in this getter!!!!!!!!!!!
    public String get_id() {
        return _id.toHexString();
    }
}
