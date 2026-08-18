package lk.ijse.eca.pet_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    private String id;

    private String name;
    private String species;
    private String breed;
    private int age;
    private Long ownerId;
    private String imageUrl; // Cloud Storage bucket URL
}