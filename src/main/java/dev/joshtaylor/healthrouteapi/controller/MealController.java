package dev.joshtaylor.healthrouteapi.controller;
import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.domain.Meal;
import dev.joshtaylor.healthrouteapi.exception.MealNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1/meals")
public class MealController
{
    @Autowired
    private MealRepository mealRepository;
    @GetMapping("")
    public ResponseEntity<List<Meal>> getAllMeals ()
    {
        List<Meal> meals = mealRepository.findAll();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Meal> createMeal (@RequestBody Meal mealReq) {
        Meal newMeal = new Meal(mealReq.getTimestamp());
        Meal meal = mealRepository.save(newMeal);
        return new ResponseEntity<>(meal, HttpStatus.CREATED);
    }

    @GetMapping("/{meal_id}")
    public ResponseEntity<Meal> getMealById (@PathVariable Long meal_id) {
        Optional<Meal> optionalMeal = mealRepository.findById(meal_id);
        if (optionalMeal.isPresent()) {
            Meal meal = optionalMeal.get();
            return new ResponseEntity<>(meal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{meal_id}")
    public ResponseEntity<Meal> deleteMeal (@PathVariable Long meal_id) {
        Optional<Meal> optionalMeal = mealRepository.findById(meal_id);
        if (optionalMeal.isPresent()) {
            mealRepository.deleteById(meal_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{meal_id}/day")
    public ResponseEntity<Meal> addMealToDay (@PathVariable Long meal_id,
    @RequestBody Day day) {
        Long dayId = day.getId();
        Optional<Meal> optionalMeal = mealRepository.findById(meal_id);

        if (optionalMeal.isPresent()) {
            Meal meal = optionalMeal.get();
            meal.setDay_id(dayId);
            Meal updatedMeal = mealRepository.save(meal);
            return new ResponseEntity<>(updatedMeal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
