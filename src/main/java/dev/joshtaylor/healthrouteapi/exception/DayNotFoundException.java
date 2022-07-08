package dev.joshtaylor.healthrouteapi.exception;

public class DayNotFoundException extends RuntimeException {
    public DayNotFoundException (Long dayId) {
        super("Could not find " + "day: " + dayId);
    }
}
