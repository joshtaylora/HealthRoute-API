package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.domain.Food;
import dev.joshtaylor.healthrouteapi.domain.Medication;
import dev.joshtaylor.healthrouteapi.exception.MedicationNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping()
    public ResponseEntity<List<Medication>> getAllMedications () {
        List<Medication> medications = medicationRepository.findAll();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Medication> createMedication (@RequestBody Medication newMed) {

        Medication med = medicationRepository.save(newMed);
        return new ResponseEntity<>(med, HttpStatus.CREATED);
    }

    @GetMapping("/{medication_id}")
    public ResponseEntity<Medication> getMedicationById (@PathVariable Long medication_id) {
        Optional<Medication> optionalMedication =
                medicationRepository.findById(medication_id);
        if (optionalMedication.isPresent()) {
            Medication med = optionalMedication.get();
            return new ResponseEntity<>(med, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{medication_id}/day")
    public ResponseEntity<Medication> addMedicationToDay (@PathVariable Long medication_id,
                                          @RequestBody Day day) {

        Optional<Medication> optionalMedication = medicationRepository.findById(medication_id);
        if (optionalMedication.isPresent()) {
            Medication med = optionalMedication.get();
            med.setDay_id(day.getId());
            Medication updatedMed = medicationRepository.save(med);
            return new ResponseEntity<>(updatedMed, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
