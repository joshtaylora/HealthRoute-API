package dev.joshtaylor.healthrouteapi.exception;

public class MealNotFoundException extends RuntimeException {
    public MealNotFoundException (Long mealId) {
        super("Could not find meal " + mealId);
    }
}
