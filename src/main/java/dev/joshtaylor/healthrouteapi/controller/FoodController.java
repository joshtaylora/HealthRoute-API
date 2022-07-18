package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Food;
import dev.joshtaylor.healthrouteapi.exception.FoodNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.FoodRepository;
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
@RequestMapping("/api/v1/foods")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("")
    public ResponseEntity<List<Food>> getAllFoods () {

        List<Food> foods = foodRepository.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Food> createFood (@RequestBody Food newFood) {

        Food food = foodRepository.save(newFood);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/{food_id}")
    public ResponseEntity<Food> getFoodById (@PathVariable Long food_id) {

        Optional<Food> optionalFood = foodRepository.findById(food_id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{food_id}")
    public ResponseEntity<Food> deleteFood (@PathVariable Long food_id) {

        Food deleteFood = foodRepository.findById(food_id)
                                        .orElseThrow(() -> new FoodNotFoundException(
                                                food_id));
        foodRepository.deleteById(food_id);
        return new ResponseEntity<>(deleteFood, HttpStatus.OK);
    }

    @PatchMapping("/{food_id}")
    public ResponseEntity<Food> updateFood (@PathVariable Long food_id,
    @RequestBody Food food) {
        Optional<Food> oldFood = foodRepository.findById(food_id);
        if (oldFood.isPresent()) {
            foodRepository.save(food);
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(food, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{food_id}/{meal_id}")
    public ResponseEntity<Food> addFoodToMeal (@PathVariable Long food_id,
                                  @PathVariable Long meal_id) {

        Optional<Food> optionalFood = foodRepository.findById(food_id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setMeal_id(meal_id);
            Food updatedFood = foodRepository.save(food);
            return new ResponseEntity<>(updatedFood, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
