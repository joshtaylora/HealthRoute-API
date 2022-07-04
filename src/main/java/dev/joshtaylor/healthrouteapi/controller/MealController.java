package dev.joshtaylor.healthrouteapi.controller;
import dev.joshtaylor.healthrouteapi.domain.Meal;
import dev.joshtaylor.healthrouteapi.exception.MealNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController
{
    @Autowired
    private MealRepository mealRepository;
    @GetMapping("")
    public List<Meal> getAllMeals()
    {
        return mealRepository.findAll();
    }

    @PostMapping("")
    public Meal createMeal (@RequestBody Meal mealReq) {
        Meal newMeal = new Meal(mealReq.getTimestamp());
        return mealRepository.save(newMeal);
    }

    @GetMapping("/{mealId}")
    public Meal getMealById(@PathVariable Long mealId) {
        return mealRepository.findById(mealId)
                .orElseThrow(() -> new MealNotFoundException(mealId));
    }
}
