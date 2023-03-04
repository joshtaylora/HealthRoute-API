package dev.joshtaylor.healthrouteapi.repository;

import dev.joshtaylor.healthrouteapi.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByDayId(Long dayId);

    @Transactional
    void deleteByDayId(long dayId);
}
