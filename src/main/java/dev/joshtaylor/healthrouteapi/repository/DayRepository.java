package dev.joshtaylor.healthrouteapi.repository;

import dev.joshtaylor.healthrouteapi.domain.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {}
