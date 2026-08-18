package lk.ijse.eca.pet_service.service;

import lk.ijse.eca.pet_service.model.Pet;
import lk.ijse.eca.pet_service.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(String id, Pet petDetails) {
        Pet pet = getPetById(id);
        pet.setName(petDetails.getName());
        pet.setSpecies(petDetails.getSpecies());
        pet.setBreed(petDetails.getBreed());
        pet.setAge(petDetails.getAge());
        pet.setOwnerId(petDetails.getOwnerId());
        return petRepository.save(pet);
    }

    public void deletePet(String id) {
        petRepository.deleteById(id);
    }
}