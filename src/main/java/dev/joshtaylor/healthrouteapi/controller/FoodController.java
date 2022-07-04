package dev.joshtaylor.healthrouteapi.controller;

import dev.joshtaylor.healthrouteapi.domain.Food;
import dev.joshtaylor.healthrouteapi.exception.FoodNotFoundException;
import dev.joshtaylor.healthrouteapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/{foodId}")
    public Food getFoodById (@PathVariable Long foodId) {

        return foodRepository.findById(foodId)
            .orElseThrow(() -> new FoodNotFoundException(foodId));
    }

    @GetMapping("/meal/{mealId}")
    public List<Food> getMealFoods(@PathVariable Long mealId) {
        return foodRepository.findAllByMealId(mealId);
    }
}
