package lk.ijse.eca.pet_service.controller;

import lk.ijse.eca.pet_service.model.Pet;
import lk.ijse.eca.pet_service.service.PetService;
import lk.ijse.eca.pet_service.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private StorageService storageService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable String id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.createPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable String id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.updatePet(id, pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<Pet> uploadPetImage(@PathVariable String id,
                                              @RequestParam("file") MultipartFile file) throws IOException {
        String imageUrl = storageService.uploadFile(file);

        Pet pet = petService.getPetById(id);
        pet.setImageUrl(imageUrl);
        Pet updatedPet = petService.updatePet(id, pet);

        return ResponseEntity.ok(updatedPet);
    }
}