package dev.joshtaylor.healthrouteapi.repository;

import dev.joshtaylor.healthrouteapi.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>
{}
