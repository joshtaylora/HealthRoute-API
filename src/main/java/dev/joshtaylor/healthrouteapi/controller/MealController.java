package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Day;
import dev.joshtaylor.healthrouteapi.domain.Meal;
import dev.joshtaylor.healthrouteapi.exception.DayNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.DayRepository;
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
@RequestMapping("/api/v1/")
public class MealController {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("meals")
    public ResponseEntity<List<Meal>> getAllMeals () {

        List<Meal> meals = mealRepository.findAll();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PostMapping("days/{day_id}/meals")
    public ResponseEntity<Meal> createMeal (@PathVariable Long day_id,
                                            @RequestBody Meal mealReq) {

        Meal newMeal = dayRepository.findById(day_id).map(day -> {
            mealReq.setDay(day);
            return mealRepository.save(mealReq);
        }).orElseThrow(() -> new DayNotFoundException(day_id));
        return new ResponseEntity<>(newMeal, HttpStatus.CREATED);
    }

    @GetMapping("meals/{meal_id}")
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

    @DeleteMapping("meals/{meal_id}")
    public ResponseEntity<Meal> deleteMeal (@PathVariable Long meal_id) {

        Optional<Meal> optionalMeal = mealRepository.findById(meal_id);
        if (optionalMeal.isPresent()) {
            mealRepository.deleteById(meal_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("meals/{meal_id}")
    public ResponseEntity<Meal> updateMeal (@PathVariable Long meal_id,
                                            @RequestBody Meal reqMeal) {

        Optional<Meal> optionalMeal = mealRepository.findById(meal_id);
        if (optionalMeal.isPresent()) {
            Meal updatedMeal = mealRepository.save(reqMeal);
            return new ResponseEntity<>(updatedMeal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
