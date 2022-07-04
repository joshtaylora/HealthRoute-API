package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Medication;
import dev.joshtaylor.healthrouteapi.exception.MedicationNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController
{
    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping()
    public List<Medication> getAllMedications()
    {
        return medicationRepository.findAll();
    }

    @PostMapping("")
    public Medication createMedication (@RequestBody Medication newMed) {
        return medicationRepository.save(newMed);
    }

    @GetMapping("/{medicationId}")
    public Medication getMedicationById(@PathVariable Long medicationId) {
        return medicationRepository.findById(medicationId)
                .orElseThrow(() -> new MedicationNotFoundException(medicationId));
    }
}
