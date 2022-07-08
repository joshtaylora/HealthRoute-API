package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Food;
import dev.joshtaylor.healthrouteapi.exception.FoodNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.FoodRepository;
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
@RequestMapping("/api/v1/foods")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("")
    public List<Food> getAllFoods () {

        return foodRepository.findAll();
    }

    @PostMapping("")
    public Food createFood (@RequestBody Food newFood) {

        return foodRepository.save(newFood);
    }

    @GetMapping("/{food_id}")
    public Food getFoodById (@PathVariable Long food_id) {

        return foodRepository.findById(food_id)
            .orElseThrow(() -> new FoodNotFoundException(food_id));
    }

    @DeleteMapping("/{food_id}")
    public Food deleteFood (@PathVariable Long food_id) {
        Food deleteFood = foodRepository.findById(food_id)
                .orElseThrow(() -> new FoodNotFoundException(food_id));
        foodRepository.deleteById(food_id);
        return deleteFood;
    }

    @PatchMapping("/{food_id}/{meal_id}")
    public Food addFoodToMeal(@PathVariable Long food_id, @PathVariable Long meal_id) {
        Food food = foodRepository.getById(food_id);
        food.setMeal_id(meal_id);
        return foodRepository.save(food);
    }
}
