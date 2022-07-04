package dev.joshtaylor.healthrouteapi.repository;

import dev.joshtaylor.healthrouteapi.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    public List<Food> findAllByMealId(Long mealId);
}
