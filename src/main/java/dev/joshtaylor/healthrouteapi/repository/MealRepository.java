package dev.joshtaylor.healthrouteapi.repository;

import dev.joshtaylor.healthrouteapi.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>
{
    List<Meal> findyByDayId(Long dayId);

    @Transactional
    void deleteByDayId(long dayId);
}
