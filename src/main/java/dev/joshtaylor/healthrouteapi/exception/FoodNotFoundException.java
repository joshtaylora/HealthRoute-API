package dev.joshtaylor.healthrouteapi.exception;

public class FoodNotFoundException  extends RuntimeException {
    public FoodNotFoundException (Long foodId) {
        super("Could not find food " + foodId);
    }
}
