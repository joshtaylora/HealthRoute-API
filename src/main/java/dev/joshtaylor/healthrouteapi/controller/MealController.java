package dev.joshtaylor.healthrouteapi.controller;
import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.domain.Meal;
import dev.joshtaylor.healthrouteapi.exception.MealNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @GetMapping("/{meal_id}")
    public Meal getMealById (@PathVariable Long meal_id) {
        return mealRepository.findById(meal_id)
                .orElseThrow(() -> new MealNotFoundException(meal_id));
    }

    @DeleteMapping("/{meal_id}")
    public Meal deleteMeal (@PathVariable Long meal_id) {
        Meal deleteMeal = mealRepository.findById(meal_id)
                .orElseThrow(() -> new MealNotFoundException(meal_id));
        mealRepository.deleteById(meal_id);
        return deleteMeal;
    }

    @PatchMapping("/{meal_id}/day")
    public Meal addMealToDay (@PathVariable Long meal_id, @RequestBody Day day) {
        Long dayId = day.getId();
        Meal meal = mealRepository.getById(meal_id);
        meal.setDay_id(dayId);
        return mealRepository.save(meal);
    }

}
