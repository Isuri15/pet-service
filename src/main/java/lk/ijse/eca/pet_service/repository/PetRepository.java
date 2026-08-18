package lk.ijse.eca.pet_service.repository;

import lk.ijse.eca.pet_service.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
}